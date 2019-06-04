package com.only.tech.user.service.facade;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.only.tech.entity.user.CommunicationMrgAcount;
import com.only.tech.user.service.biz.CommunicationMrgAcountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ZHI ZUN BAO
 * @since 2019/3/22
 */
@Slf4j
@Service
public class CommunicationMrgAcountFacade {

    @Autowired
    private CommunicationMrgAcountService communicationMrgAcountService;


    public CommunicationMrgAcount getByIdentifier(String identifier){
        Wrapper qw = new QueryWrapper<>().eq("identifier",identifier);
        return communicationMrgAcountService.getOne(qw);
    }
}
