package com.only.tech.user.service.infzImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.only.tech.entity.user.CustomerAccount;
import com.only.tech.entity.user.ReadTimePerday;
import com.only.tech.exposeinfz.user.api.CustomerAccountInfz;
import com.only.tech.exposeinfz.user.api.ReadTimePerdayInfz;
import com.only.tech.user.service.biz.CustomerAccountService;
import com.only.tech.user.service.biz.ReadTimePerdayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * infz实现类： 用户每日阅读时长
 * @author shutong
 * @since 2019/05/08
 */
@Slf4j
@Component
@Service(interfaceClass = ReadTimePerdayInfz.class)
public class ReadTimePerdayInfzImpl implements ReadTimePerdayInfz {

    @Autowired
    private ReadTimePerdayService readTimePerdayService;


    /**
     * 查询用户每日阅读时长
     * @param cuId
     * @param ymd
     * @return
     */
    @Override
    public ReadTimePerday getOneByCondition(Long cuId, String ymd) {
        return this.readTimePerdayService.getOneByCondition(cuId,ymd);
    }

    /**
     * 修改or添加
     * @param readTimePerday
     */
    @Override
    public void saveOrUpdate(ReadTimePerday readTimePerday) {
        this.readTimePerdayService.saveOrUpdate(readTimePerday);
    }
}
