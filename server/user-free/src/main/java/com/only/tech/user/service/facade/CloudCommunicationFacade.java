package com.only.tech.user.service.facade;

import com.alibaba.druid.support.json.JSONUtils;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.only.tech.constant.CustomerTypeConstants;
import com.only.tech.constant.TencentApiConstants;
import com.only.tech.entity.user.CloudCommunication;
import com.only.tech.entity.user.CommunicationMrgAcount;
import com.only.tech.entity.user.Customer;
import com.only.tech.user.dto.CloudCommunicationDto;
import com.only.tech.user.service.biz.CloudCommunicationService;
import com.only.tech.user.wxsdk.WXPayUtil;
import com.tls.tls_sigature.tls_sigature;
import lombok.extern.slf4j.Slf4j;
import ooh.chaos.util.DateFormatUtil;
import ooh.chaos.util.HttpUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author ZHI ZUN BAO
 * @since 2019/3/12
 */
@Slf4j
@Service
public class CloudCommunicationFacade {

    @Autowired
    private CloudCommunicationService communicationService;

    @Autowired
    private CustomerFacade customerFacade;

    @Autowired
    private CommunicationMessageFacade communicationMessageFacade;

    @Autowired
    private CommunicationMrgAcountFacade communicationMrgAcountFacade;


    @Transactional(rollbackFor = Exception.class)
    public CloudCommunicationDto getDtoByUid(Long cuId) {

        CloudCommunication communication = getByCuid(cuId);

        if (communication == null){
            //在云通信中未注册,去注册
            Customer customer = customerFacade.getByCuid(cuId);
            if (customer == null){
                log.error("用户不存在");
                return null;
            }else {
                boolean register = registerAccount(customer);
                //腾讯云注册
                if (register){
                    communication = getByCuid(cuId);
                }else {
                    return null;
                }
            }
        }

        //判断签名是否过期
        Date expireDate = communication.getExpireDate();
        Date now = new Date();
        Integer integer = DateFormatUtil.compareDate(now, expireDate);
        if (integer >= 0){
            String usersig = getUsersig(communication.getIdentifier());
            if (StringUtils.isNotBlank(usersig)){
                communication.setUsersig(usersig);
                expireDate = DateFormatUtil.addSecond(now, TencentApiConstants.COMMUNICATION_EXPIRE - 120);
                communication.setExpireDate(expireDate);
                boolean update = communicationService.updateById(communication);
            }
        }

        CloudCommunicationDto dto = new CloudCommunicationDto();
        BeanUtils.copyProperties(communication,dto);

        //获取用户头像
        String avatar = customerFacade.getUserAvatar(cuId);
        dto.setFaceUrl(avatar);

        return dto;
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean registerAccount(Customer customer) {
        CloudCommunication communication = new CloudCommunication();
        Long cuId = customer.getCuId();
        communication.setCuId(cuId);
        communication.setIdentifier(TencentApiConstants.IDENTIFIER_PREFIX+cuId);
        String nickName = customer.getNickName();
        communication.setNick(nickName);
        communication.setFaceUrl(customer.getAvatar());

        String userType = customer.getUserType();
        if (StringUtils.isNotBlank(userType)){
            if (CustomerTypeConstants.USER_TYPE_ROBOT.equals(userType)){
                communication.setType(1);
            }else {
                communication.setType(0);
            }
        }

        return register(communication);
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean register(CloudCommunication communication) {
        /** 在腾讯云通信注册 */
        Map<String,Object> map = getParms(communication);
        if (map == null){
            return false;
        }

        try {
            boolean register = communicationRegister(map);
            if (register){
                Date now = new Date();
                communication.setCreateDate(now);
                Date expireDate = DateFormatUtil.addSecond(now, TencentApiConstants.COMMUNICATION_EXPIRE - 120);
                communication.setExpireDate(expireDate);
                String usersig = getUsersig(communication.getIdentifier());
                communication.setUsersig(usersig);

                boolean save = communicationService.save(communication);
                return save;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean communicationRegister(Map<String, Object> map) {

        String xmlStr = JSONUtils.toJSONString(map);

        String adminUrlSig = getUsersig(TencentApiConstants.IDENTIFIER);

        String url = TencentApiConstants.COMMUNICATION_ACCOUNT_IMPORT_URL + "?usersig=" + adminUrlSig
                 + "&identifier=" + TencentApiConstants.IDENTIFIER + "&sdkappid=" + TencentApiConstants.SDKAPPID + "&random="+ WXPayUtil.generateNonceStr() + "&contenttype=json";

        String resultStr = HttpUtils.httpPost(url, xmlStr);
        log.info("导入用户：[{}]",resultStr);
        /** 记录到数据库中 */
        if (StringUtils.isNotBlank(resultStr)){
            Map<String, Object> xmlToMap = (Map<String, Object>) JSONUtils.parse(resultStr);
            String actionStatus = xmlToMap.get("ActionStatus").toString();
            String errorCode = xmlToMap.get("ErrorCode").toString();
            String errorInfo = xmlToMap.get("ErrorInfo").toString();

            log.info("actionStatus : [{}]",actionStatus);

            if (StringUtils.isNotBlank(actionStatus) && "OK".equals(actionStatus)){
                if (StringUtils.isNotBlank(errorCode) && "0".equals(errorCode)){
                    return true;
                }
            }else {
                log.error("errorCode : [{}]",errorCode);
                log.error("errorInfo : [{}]",errorInfo);
            }
        }
        return false;
    }

    private Map<String, Object> getParms(CloudCommunication communication) {
        Map<String, Object> map = new HashMap<>();
        map.put("Identifier",communication.getIdentifier());
        map.put("Nick",communication.getNick());
        map.put("FaceUrl",communication.getFaceUrl());
        map.put("Type",communication.getType());

        return map;
    }

    private String getUsersig(String identifier) {
        tls_sigature.GenTLSSignatureResult genTLSSignatureResult
                = tls_sigature.genSig(TencentApiConstants.SDKAPPID,identifier, TencentApiConstants.COMMUNICATION_EXPIRE, TencentApiConstants.PRIVATE_KEY);
        return genTLSSignatureResult.urlSig;
    }


    public CloudCommunication getByCuid(Long cuId) {
        Wrapper qw = new QueryWrapper<>().eq("cuId",cuId);
        return communicationService.getOne(qw);
    }


    @Async
    @Transactional(rollbackFor = Exception.class)
    public void newUserReissue(Customer customer) {
        try {
            boolean registerAccount = this.registerAccount(customer);
            if (registerAccount){
                Long cuId = customer.getCuId();
                CloudCommunication communication = getByCuid(cuId);
                if (communication != null){
                    communicationMessageFacade.ReissueMsg(communication.getIdentifier());
                }
            }
        } catch (Exception e) {
            log.error("新用户补发消息错误：",e);
        }
    }


    public List<CloudCommunicationDto> getList(List<String> uidList) {
        List<CloudCommunicationDto> dtoList = new ArrayList<>();
        if (uidList != null && !uidList.isEmpty()){

            for (String identifier: uidList) {
                CloudCommunicationDto dto = null;

                if (StringUtils.isBlank(identifier)){
                    continue;
                }

                int indexOf = identifier.indexOf(TencentApiConstants.COMMUNICATION_IDENTIFIER_PREFIX);

                if (indexOf >= 0){
                    //管理账户

                    CommunicationMrgAcount mrgAcount = communicationMrgAcountFacade.getByIdentifier(identifier);
                    if (mrgAcount != null){
                        dto = new CloudCommunicationDto();
                        dto.setIdentifier(identifier);
                        dto.setNick(mrgAcount.getNick());
                        dto.setFaceUrl(mrgAcount.getFaceUrl());

                    }
                }else {
                    //客户
                    dto = getDtoByUid(Long.parseLong(identifier));
                }
                if (dto != null){
                    dtoList.add(dto);
                }
            }
        }
        return dtoList;
    }
}
