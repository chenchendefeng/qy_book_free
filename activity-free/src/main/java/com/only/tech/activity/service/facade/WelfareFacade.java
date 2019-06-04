package com.only.tech.activity.service.facade;

import com.alibaba.dubbo.config.annotation.Reference;
import com.only.tech.activity.common.dto.WelfarePageDto;
import com.only.tech.activity.service.biz.ReceiveWelfareService;
import com.only.tech.activity.service.biz.WelfareService;
import com.only.tech.base.result.ResultDto;
import com.only.tech.base.result.ResultEnum;
import com.only.tech.constant.ActivityConstants;
import com.only.tech.dto.activity.WelfareDto;
import com.only.tech.entity.activity.ReceiveWelfare;
import com.only.tech.entity.activity.Welfare;
import com.only.tech.entity.user.Customer;
import com.only.tech.enums.AccountChangeSpecificTypeEnum;
import com.only.tech.enums.AccountChangeTypeEnum;
import com.only.tech.enums.CurrencyTypeEnum;
import com.only.tech.enums.WelfareTypeEnum;
import com.only.tech.exposeinfz.user.api.CustomerAccountInfz;
import com.only.tech.exposeinfz.user.api.CustomerInfz;
import ooh.chaos.exception.BusinessException;
import ooh.chaos.util.DateFormatUtil;
import ooh.chaos.util.NumUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/10
 */
@Service
public class WelfareFacade {

    @Autowired
    private WelfareService welfareService;

    @Autowired
    private ReceiveWelfareService receiveWelfareService;

    @Reference
    private CustomerInfz customerInfz;

    @Reference
    private CustomerAccountInfz customerAccountInfz;


    public WelfarePageDto getPageDate(Long cuId) {
        WelfarePageDto pageDto = new WelfarePageDto();

        Date now = new Date();

        //新手福利
        Customer customer = customerInfz.getOneByCuid(cuId);
        if (customer != null){
            Date regDate = customer.getRegDate();
            Integer minutes = DateFormatUtil.countMinutes(now, regDate);
            List<Welfare> nlist  = welfareService.getByType(ActivityConstants.NOVICE,minutes);
            if (!nlist.isEmpty()) {
                //去除已经领取的福利
                List<ReceiveWelfare> receiveWelfareList = receiveWelfareService.getByCuidAndTypeAndDate(cuId,ActivityConstants.NOVICE,null);
                if (!receiveWelfareList.isEmpty()){
                    Iterator<Welfare> it = nlist.iterator();
                    while (it.hasNext()){
                        Welfare welfare = it.next();
                        for (ReceiveWelfare receiveWelfare : receiveWelfareList) {
                            if (welfare.getType().equals(receiveWelfare.getType()) && welfare.getWelfareType().equals(receiveWelfare.getWelfareType())){
                                it.remove();
                            }
                        }
                    }
                }
                List<WelfareDto> noviceList = convertList(nlist);
                pageDto.setNoviceList(noviceList);
            }
        }


        //阅读福利
        List<Welfare> rlist  = welfareService.getByType(ActivityConstants.READ, null);
        if (!rlist.isEmpty()) {
            List<WelfareDto> readList = convertList(rlist);
            pageDto.setReadList(readList);
        }

        //日常福利
        List<Welfare> dlist  = welfareService.getByType(ActivityConstants.DAILY, null);
        if (!dlist.isEmpty()) {
            //去除已经领取的福利
            List<ReceiveWelfare> receiveWelfareList = receiveWelfareService.getByCuidAndTypeAndDate(cuId,ActivityConstants.DAILY,DateFormatUtil.formatShort(now));
            if (!receiveWelfareList.isEmpty()){
                Iterator<Welfare> it = dlist.iterator();
                while (it.hasNext()){
                    Welfare welfare = it.next();
                    for (ReceiveWelfare receiveWelfare : receiveWelfareList) {
                        if (welfare.getType().equals(receiveWelfare.getType()) && welfare.getWelfareType().equals(receiveWelfare.getWelfareType())){
                            it.remove();
                        }
                    }
                }
            }
            List<WelfareDto> dailyList = convertList(dlist);
            pageDto.setDailyList(dailyList);
        }

        return pageDto;
    }

    

    public List<WelfareDto> convertList(List<Welfare> list) {
        List<WelfareDto> noviceList = new ArrayList<>(list.size());
        for (Welfare data: list) {
            WelfareDto dto = new WelfareDto();
            BeanUtils.copyProperties(data,dto);
            noviceList.add(dto);
        }
        return noviceList;
    }

    /**
     * 看视频免广告20分钟
     * @param cuId
     * @param timeMinute
     */
    public void watchForFreeAdv(Long cuId, int timeMinute) {
        this.customerInfz.watchForFreeAdv(cuId,timeMinute);
    }

    /**
     * 看视频奖励金豆
     * @param cuId
     * @return
     */
    public ResultDto videoForGole(Long cuId) {
        Date now = new Date();
        String dateStr = DateFormatUtil.formatShort(now);

        List<ReceiveWelfare> list = receiveWelfareService.getByCuidAndWefareTypeAndDate(cuId, WelfareTypeEnum.VIDEO_FOR_GOLD.getType(),dateStr);
        if (list.isEmpty()){
            ReceiveWelfare receiveWelfare = new ReceiveWelfare();
            receiveWelfare.setCuId(cuId);
            receiveWelfare.setCreateTime(now);
            receiveWelfare.setDate(dateStr);
            receiveWelfare.setType(ActivityConstants.DAILY);
            receiveWelfare.setWelfareType(WelfareTypeEnum.VIDEO_FOR_GOLD.getType());

            boolean save = receiveWelfareService.save(receiveWelfare);
            if (save){
                //奖励
                boolean award = awardWatchForGole(cuId);
                if (award){
                    return ResultDto.succesResult(ActivityConstants.VIDEO_FOR_GOLD_100);
                }else {
                    ResultEnum resultEnum = ResultEnum.ERROR;
                    resultEnum.setMsg("奖励失败");
                    throw new BusinessException(resultEnum);
                }
            }
        }

        return ResultDto.errorResult("每天只能奖励一次");
    }

    private boolean awardWatchForGole(Long cuId) {
        return customerAccountInfz.attendanceChange(cuId, CurrencyTypeEnum.GOLD,ActivityConstants.VIDEO_FOR_GOLD_100, AccountChangeTypeEnum.REWARD, AccountChangeSpecificTypeEnum.WATCH_SMALL_VIDEO_AWARD);
    }


    /**
     * 每日分享奖励
     * @param cuId
     * @return
     */
    public ResultDto shareForGole(Long cuId) {
        Date now = new Date();
        String dateStr = DateFormatUtil.formatShort(now);

        List<ReceiveWelfare> list = receiveWelfareService.getByCuidAndWefareTypeAndDate(cuId, WelfareTypeEnum.DAILY_SHARE_FOR_GOLD.getType(),dateStr);
        if (list.isEmpty()){
            ReceiveWelfare receiveWelfare = new ReceiveWelfare();
            receiveWelfare.setCuId(cuId);
            receiveWelfare.setCreateTime(now);
            receiveWelfare.setDate(dateStr);
            receiveWelfare.setType(ActivityConstants.DAILY);
            receiveWelfare.setWelfareType(WelfareTypeEnum.DAILY_SHARE_FOR_GOLD.getType());

            boolean save = receiveWelfareService.save(receiveWelfare);

            if (save){
                //奖励
                Integer gole = awardShareForGole(cuId);
                if (gole != null){
                    return ResultDto.succesResult(gole);
                }else {
                    ResultEnum resultEnum = ResultEnum.ERROR;
                    resultEnum.setMsg("奖励失败");
                    throw new BusinessException(resultEnum);
                }
            }
        }

        return ResultDto.errorResult("每天只能奖励一次");
    }

    private Integer awardShareForGole(Long cuId) {
        int random = NumUtil.getRandom(1, 100);
        AccountChangeSpecificTypeEnum sharingAward = AccountChangeSpecificTypeEnum.DAILY_SHARING_AWARD;
        sharingAward.setRemark(random + "");
        boolean change = customerAccountInfz.attendanceChange(cuId, CurrencyTypeEnum.GOLD, Long.valueOf(random), AccountChangeTypeEnum.REWARD, sharingAward);
        return change?random:null;
    }

    /**
     * 检查看视频领金豆领取状态
     * @param cuId
     * @return
     */
    public Integer videoForGoleCheck(Long cuId) {

        Date now = new Date();
        String dateStr = DateFormatUtil.formatShort(now);

        List<ReceiveWelfare> list = receiveWelfareService.getByCuidAndWefareTypeAndDate(cuId, WelfareTypeEnum.VIDEO_FOR_GOLD.getType(),dateStr);

        return list.isEmpty()? 0 : 1;
    }
}
