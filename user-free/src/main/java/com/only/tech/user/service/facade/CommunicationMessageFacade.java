package com.only.tech.user.service.facade;

import com.alibaba.druid.support.json.JSONUtils;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.constant.TencentApiConstants;
import com.only.tech.dto.user.CommunicationMessageDto;
import com.only.tech.entity.user.CloudCommunication;
import com.only.tech.entity.user.CommunicationMessage;
import com.only.tech.user.service.biz.CloudCommunicationService;
import com.only.tech.user.service.biz.CommunicationMessageService;
import com.only.tech.user.wxsdk.WXPayUtil;
import com.tls.tls_sigature.tls_sigature;
import lombok.extern.slf4j.Slf4j;
import ooh.chaos.util.DateFormatUtil;
import ooh.chaos.util.HttpUtils;
import ooh.chaos.util.NumUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author ZHI ZUN BAO
 * @since 2019/3/15
 */
@Slf4j
@Service
public class CommunicationMessageFacade {

    @Autowired
    private CommunicationMessageService communicationMessageService;

    @Autowired
    private CloudCommunicationService cloudCommunicationService;


    private String getUsersig(String identifier) {
        tls_sigature.GenTLSSignatureResult genTLSSignatureResult
                = tls_sigature.genSig(TencentApiConstants.SDKAPPID,identifier, TencentApiConstants.COMMUNICATION_EXPIRE, TencentApiConstants.PRIVATE_KEY);
        return genTLSSignatureResult.urlSig;
    }

    public List<CommunicationMessage> getMessagerList() {
        Date now = new Date();
        Date endDate = DateFormatUtil.addMinute(now, 5);
        Wrapper qw = new QueryWrapper<>().eq("sendStatus",0).eq("timing",1).between("sendTime",now,endDate);
        return communicationMessageService.list(qw);
    }


    public PageData getPage(Integer sendStatus, String startTime, String endTime, PageReq pageReq) {
        Page page = PageHelper.startPage(pageReq.getPageNo(),pageReq.getPageSize());
        communicationMessageService.getDtoList(sendStatus,startTime,endTime);

        PageData pageData = new PageData(page);

        return pageData;
    }



    public boolean insert(CommunicationMessageDto dto) {
        if (dto == null){
            return false;
        }
        Date now = new Date();
        CommunicationMessage message = new CommunicationMessage();
        BeanUtils.copyProperties(dto,message);

        //校验是否发送消息  0：不是；1：是
        Integer timing = message.getTiming();
        if (timing != null && timing.equals(0)){
            //发送消息
            boolean send = sendMsgByMessage(message);
            message.setSendStatus(send ? 1:0);
            if (send){
                message.setSendTime(now);
            }
        }
        message.setCreateDate(now);
        boolean save = communicationMessageService.save(message);

        return save;
    }

    public boolean sendMsgByMessage(CommunicationMessage message) {
        boolean send = false;
        Integer msgType = message.getMsgType();

        //组装数据
        //基础数据
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("SyncOtherMachine",2);
        paramMap.put("From_Account",message.getFromIdentifier());
        paramMap.put("MsgLifeTime",3600);
        int random = NumUtil.getRandom(1, 99999999);
        paramMap.put("MsgRandom",random);
        paramMap.put("MsgTimeStamp", DateFormatUtil.getCurrentTimestamp());

        //消息实体
        Map<String,Object> bodyMap = new HashMap<>();
        bodyMap.put("MsgType","TIMCustomElem");

        //消息内容
        Map<String,Object> contentMap = new HashMap<>();

        contentMap.put("Desc",message.getContent());
        contentMap.put("Ext","");
        contentMap.put("Sound","dingdong.aiff");

        Map<String,String> dataMap = new HashMap<>();
        String jumpType = message.getJumpType();
        if (StringUtils.isNotBlank(jumpType)){
            dataMap.put("jumpType",jumpType);
        }
        String fileUrl = message.getFileUrl();
        if (StringUtils.isNotBlank(fileUrl)){
            dataMap.put("fileUrl",fileUrl);
        }
        String directionPath = message.getDirectionPath();
        if (StringUtils.isNotBlank(directionPath)){
            dataMap.put("directionPath",directionPath);
        }
        String title = message.getTitle();
        if (StringUtils.isNotBlank(title)){
            dataMap.put("title",title);
        }
        String content = message.getContent();
        if (StringUtils.isNotBlank(content)){
            dataMap.put("content",content);
        }

        String dataStr = JSONUtils.toJSONString(dataMap);
        contentMap.put("Data",dataStr);

        bodyMap.put("MsgContent",contentMap);

        bodyMap.put("Data","TIMCustomElem");

        List<Map<String,Object>> bodyList = new ArrayList<>();
        bodyList.add(bodyMap);
        paramMap.put("MsgBody",bodyList);

        //消息离线推送信息
        Map<String,Object> OfflinePushInfoMap = new HashMap<>();
        OfflinePushInfoMap.put("PushFlag",0);
        OfflinePushInfoMap.put("Desc","离线推送内容");
        OfflinePushInfoMap.put("Ext","这是透传的内容");

        Map<String,Object> androidInfoMap = new HashMap<>();
        androidInfoMap.put("Sound","android.mp3");
        OfflinePushInfoMap.put("AndroidInfo",androidInfoMap);

        Map<String,Object> apnsInfoMap = new HashMap<>();
        apnsInfoMap.put("Sound","apns.mp3");
        apnsInfoMap.put("BadgeMode",0);
        apnsInfoMap.put("Title","apns title");
        apnsInfoMap.put("SubTitle","apns subtitle");
        apnsInfoMap.put("Image","apns subtitle");

        OfflinePushInfoMap.put("ApnsInfo",apnsInfoMap);


        paramMap.put("OfflinePushInfo",OfflinePushInfoMap);

        String adminUrlSig = getUsersig(TencentApiConstants.IDENTIFIER);

        if (msgType.equals(0)){

            String url = TencentApiConstants.COMMUNICATION_BATCH_SENDMSG + "?usersig=" + adminUrlSig
                    + "&identifier=" + TencentApiConstants.IDENTIFIER + "&sdkappid=" + TencentApiConstants.SDKAPPID + "&random="+ WXPayUtil.generateNonceStr() + "&contenttype=json";

            //群发
            Integer gender = message.getGender();
            Integer pageNo = 1;
            Integer pageSize = 500;

            Integer pages = 0;
            do {
                Page page = PageHelper.startPage(pageNo,pageSize);
                Wrapper qw = new QueryWrapper();
                if (gender != null){
                    ((QueryWrapper) qw).eq("gender",gender);
                }
                List<CloudCommunication> list = cloudCommunicationService.list(qw);
                if (!list.isEmpty()){
                    List<String> accountList = new ArrayList<>();
                    for (CloudCommunication account: list) {
                        accountList.add(account.getIdentifier());
                    }
                    paramMap.put("To_Account",accountList);
                }

                //发送消息
                send = sendMsg(url,paramMap);

                pages = page.getPages();
                pageNo++;

            }while (pages > pageNo);


        }else if (msgType.equals(1)){
            String url = TencentApiConstants.COMMUNICATION_SENDMSG + "?usersig=" + adminUrlSig
                    + "&identifier=" + TencentApiConstants.IDENTIFIER + "&sdkappid=" + TencentApiConstants.SDKAPPID + "&random="+ WXPayUtil.generateNonceStr() + "&contenttype=json";

            //单聊
            paramMap.put("To_Account",message.getToIdentifier());

            //发送消息
            send = sendMsg(url, paramMap);
        }

        return send;
    }

    private boolean sendMsg(String url, Map<String, Object> paramMap) {

        String xmlStr = JSONUtils.toJSONString(paramMap);

        String resultStr = HttpUtils.httpPost(url, xmlStr);

        Map<String, Object> map = (Map<String, Object>) JSONUtils.parse(resultStr);

        String actionStatus = map.get("ActionStatus").toString();
        if ("OK".equals(actionStatus)){
            //发送成功
            return true;
        }else {
            String errorInfo = map.get("ErrorInfo").toString();
            String errorCode = map.get("ErrorCode").toString();
            log.error("发送消息失败：",errorInfo);
            log.error("错误码：",errorCode);
        }

        return false;
    }

    @Async
    public void ReissueMsg(String identifier) {
        //获取最近的一条针对所有用户的推送消息
        Wrapper qw = new QueryWrapper<>().eq("msgType",0).eq("sendStatus",1).orderByDesc("createDate");
        CommunicationMessage message = communicationMessageService.getOne(qw);
        if (message == null){
            return;
        }
        message.setMsgType(1);
        message.setToIdentifier(identifier);
        boolean send = sendMsgByMessage(message);
        if (send){
            log.info("发送成功：identifier [{}]",identifier);
        }else {
            log.info("发送失败");
        }
    }

    public boolean updateSendStatus(Integer id, Integer sendStatus) {
        CommunicationMessage message = communicationMessageService.getById(id);
        if (message != null){
            message.setSendStatus(sendStatus);
            boolean update = communicationMessageService.updateById(message);
            return update;
        }
        return false;
    }
}
