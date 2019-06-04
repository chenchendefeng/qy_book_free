package com.only.tech.user.service.facade;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.constant.AccountChangeTypeConstants;
import com.only.tech.constant.ImgConstants;
import com.only.tech.constant.RmbChangeTypeConstants;
import com.only.tech.dto.user.AccountFlowRecordDto;
import com.only.tech.entity.user.AccountFlowRecord;
import com.only.tech.enums.AccountChangeSpecificTypeEnum;
import com.only.tech.enums.AccountChangeTypeEnum;
import com.only.tech.enums.CurrencyTypeEnum;
import com.only.tech.user.service.biz.AccountFlowRecordService;
import lombok.extern.slf4j.Slf4j;
import ooh.chaos.util.DateFormatUtil;
import ooh.chaos.util.NumUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/5
 */
@Slf4j
@Service
public class AccountFlowRecordFacade {

    @Autowired
    private AccountFlowRecordService accountFlowRecordService;


    /**
     * 添加记录
     * @return
     */
    public boolean record(Long cuId, CurrencyTypeEnum currencyType, Long money, AccountChangeTypeEnum changeType, AccountChangeSpecificTypeEnum specificType, String remark){
        try {
            AccountFlowRecord record = new AccountFlowRecord();
            record.setCuId(cuId);
            record.setCurrencyType(currencyType.getType());
            record.setAmount(money);
            record.setChangeType(changeType.getType());
            String title = changeType.getName();
            record.setCreateTime(new Date());
            record.setRemark(remark);
            if (specificType != null){
                record.setSpecificType(specificType.getType());
                title = specificType.getName();
            }
            record.setTitle(title);

            return accountFlowRecordService.save(record);
        } catch (Exception e) {
            log.error("添加账户流水错误：",e);
        }

        return false;
    }

    /**
     * 校验是否领取注册奖励
     * @param cuId
     * @return
     */
    public boolean alreadyRegisterRewarded(Long cuId) {
        QueryWrapper qw = new QueryWrapper<>();
        qw.eq("cuId",cuId);
        qw.eq("changeType", AccountChangeTypeEnum.REWARD.getType());
        qw.eq("specificType",AccountChangeSpecificTypeEnum.RMB_REGISTER_REDPACK.getType());
        List list = accountFlowRecordService.list(qw);

        return !list.isEmpty();
    }


    public PageData<AccountFlowRecordDto> getPage(Long cuId, String currencyType, PageReq pageReq) {

        QueryWrapper qw = new QueryWrapper();
        qw.eq("cuId",cuId);
        qw.eq("currencyType",currencyType);
        Date now = new Date();
        String endDate = DateFormatUtil.format(now);
        Date date = now;
        if (currencyType.equals(CurrencyTypeEnum.RMB.getType())){
            //人民币查询最近3天
            date = DateFormatUtil.addDay(now, -2);
        }else {
            //金豆查询最近30天
            date = DateFormatUtil.addDay(now, -29);
        }
        String startDate = DateFormatUtil.getStartDate(date);;
        qw.between("createTime",startDate,endDate);

        qw.orderByDesc("createTime");

        Page page = PageHelper.startPage(pageReq.getPageNo(),pageReq.getPageSize());
        List<AccountFlowRecord> list = accountFlowRecordService.list(qw);

        PageData pageData = new PageData(page);
        if (!list.isEmpty()){
            List<AccountFlowRecordDto> dtoList = new ArrayList<>(list.size());
            for (AccountFlowRecord record: list) {
                AccountFlowRecordDto dto = new AccountFlowRecordDto();
                BeanUtils.copyProperties(record,dto);

                Long amount = record.getAmount();
                if (record.getCurrencyType().equals(CurrencyTypeEnum.RMB.getType())){
                    dto.setAmount(NumUtil.div(amount,100));
                }else {
                    dto.setAmount(Double.valueOf(amount));
                }
                dtoList.add(dto);
            }
            pageData.setData(dtoList);
        }
        return pageData;
    }

}
