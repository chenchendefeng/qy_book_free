package com.only.tech.user.service.infzImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.constant.TencentApiConstants;
import com.only.tech.dto.user.CommunicationMrgAcountDto;
import com.only.tech.entity.user.CommunicationMrgAcount;
import com.only.tech.exposeinfz.user.api.CommunicationMrgAcountInfz;
import com.only.tech.user.service.biz.CommunicationMrgAcountService;
import com.only.tech.user.service.facade.CloudCommunicationFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ZHI ZUN BAO
 * @since 2019/3/15
 */
@Slf4j
@Component
@Service(interfaceClass = CommunicationMrgAcountInfz.class)
public class CommunicationMrgAcountInfzImpl implements CommunicationMrgAcountInfz {

    @Autowired
    private CommunicationMrgAcountService communicationMrgAcountService;

    @Autowired
    private CloudCommunicationFacade cloudCommunicationFacade;


    @Override
    public PageData<CommunicationMrgAcountDto> getPage(PageReq pageReq) {
        Page page = PageHelper.startPage(pageReq.getPageNo(),pageReq.getPageSize());
        Wrapper qw = new QueryWrapper<>();
        List<CommunicationMrgAcountDto> list = communicationMrgAcountService.list(qw);
        PageData pageData = new PageData(page);

        return pageData;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean insert(CommunicationMrgAcountDto dto) {
        //云通信注册账户
        Wrapper qw = new QueryWrapper<>().orderByDesc("id");
        CommunicationMrgAcount mrgAcount = communicationMrgAcountService.getOne(qw);
        String identifier = TencentApiConstants.COMMUNICATION_IDENTIFIER_PREFIX;
        if (mrgAcount == null){
            identifier += 1;
        }else {
            Long id = mrgAcount.getId();
            identifier = identifier + ++id;
        }
        dto.setIdentifier(identifier);

        Map<String,Object> map = getParmsMap(dto);
        boolean register = cloudCommunicationFacade.communicationRegister(map);

        if (register){
            CommunicationMrgAcount acount = new CommunicationMrgAcount();
            BeanUtils.copyProperties(dto,acount);
            Date now = new Date();
            acount.setCreateDate(now);

            boolean save = communicationMrgAcountService.save(acount);
            return save;
        }
        return false;
    }

    private Map<String, Object> getParmsMap(CommunicationMrgAcountDto dto) {
        Map<String,Object> map = new HashMap<>();
        map.put("Identifier",dto.getIdentifier());
        map.put("Nick",dto.getNick());
        map.put("FaceUrl",dto.getFaceUrl());
        Integer type = dto.getType();
        if (type != null) {
            map.put("Type",type);
        }
        return map;
    }

}
