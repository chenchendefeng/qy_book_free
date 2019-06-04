package com.only.tech.user.service.facade;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.constant.UserConstants;
import com.only.tech.dto.user.FriendInfoDto;
import com.only.tech.entity.user.Customer;
import com.only.tech.entity.user.Friend;
import com.only.tech.user.service.biz.FriendService;
import lombok.extern.slf4j.Slf4j;
import ooh.chaos.util.DateFormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author ZHI ZUN BAO
 * @since 2019/3/13
 */
@Slf4j
@Service
public class FriendFacade {

    @Autowired
    private FriendService friendService;

    @Autowired
    private CustomerFacade customerFacade;


    @Transactional(rollbackFor = Exception.class)
    public boolean add(Long cuId, Long fuId) {
        Wrapper qw = new QueryWrapper<>().eq("cuId",cuId).eq("fuId",fuId);
        Friend friend = friendService.getOne(qw);
        if (friend != null){
            return true;
        }

        Customer customer = customerFacade.getByCuid(cuId);
        if (customer == null){
            log.error("用户存在：cuId:[{}]",cuId);
            return false;
        }
        Customer fcustomer = customerFacade.getByCuid(fuId);
        if (fcustomer == null){
            log.error("用户存在：fuId:[{}]",fuId);
            return false;
        }

        friend = new Friend();
        friend.setCuId(cuId);
        friend.setFuId(fuId);
        Date now = new Date();
        friend.setCreateDate(now);

        Friend friend2 = new Friend();
        friend2.setCuId(fuId);
        friend2.setFuId(cuId);
        friend2.setCreateDate(now);

        boolean save = friendService.save(friend);
        if (save){
            save = friendService.save(friend2);
        }

        return save;
    }


    public PageData page(Long cuId, PageReq pageReq) {
        Page page = PageHelper.startPage(pageReq.getPageNo(),pageReq.getPageSize());
        List<FriendInfoDto> list = friendService.friendInfoList(cuId);
        Date now = new Date();
        PageData pageData = new PageData(page);
        if (!list.isEmpty()) {
            for (FriendInfoDto dto: list) {
                Date upTime = dto.getUpTime();
                if (upTime != null){
                    int countMinutes = DateFormatUtil.countMinutes(now, upTime);
                    String timeMsg = getTimeMsg(countMinutes);
                    dto.setTimeMsg(timeMsg);
                    int notifyStatus = 0;
                    if (countMinutes > UserConstants.HOUR_TO_MINUTES_120) {
                        notifyStatus = 1;
                    }
                    dto.setNotifyStatus(notifyStatus);
                }
            }
        }

        return pageData;
    }

    private static String getTimeMsg(int countMinutes) {
        String timeMsg = "";
        if (countMinutes < UserConstants.HOUR_TO_MINUTES_1){
            if (countMinutes == 0){
                countMinutes = 1;
            }
            timeMsg = countMinutes + "分钟前来过";
        } else if (countMinutes >= UserConstants.HOUR_TO_MINUTES_1 && countMinutes < UserConstants.HOUR_TO_MINUTES_24) {
            int hour = countMinutes / UserConstants.HOUR_TO_MINUTES_1;
            timeMsg = hour + "小时前来过";
        } else if (countMinutes >= UserConstants.HOUR_TO_MINUTES_24 && countMinutes < UserConstants.HOUR_TO_MINUTES_120) {
            int day = countMinutes / UserConstants.HOUR_TO_MINUTES_24;
            timeMsg = day + "天前来过";
        }

        return timeMsg;
    }
}
