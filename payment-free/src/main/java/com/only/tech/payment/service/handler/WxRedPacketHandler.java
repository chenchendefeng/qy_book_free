package com.only.tech.payment.service.handler;

import com.only.tech.constant.Constants;
import com.only.tech.constant.TencentApiConstants;
import com.only.tech.entity.user.RedpacketCheckResult;
import com.only.tech.entity.user.RedpacketResult;
import com.only.tech.payment.common.constant.WXPayConstants;
import com.only.tech.payment.configuration.WXPayConfigBean;
import com.only.tech.payment.wxsdk.WXPayUtil;
import lombok.extern.slf4j.Slf4j;
import ooh.chaos.util.DataConvertUtil;
import ooh.chaos.util.HttpUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/24
 */
@Slf4j
@Component
public class WxRedPacketHandler {

    @Autowired
    private WXPayConfigBean wxPayConfigBean;


    public RedpacketResult sendRedPacket(String openid, String orderNo, Integer rmbAmount) throws Exception {
        //组织参数
        Map<String, String> params = getParams(openid, orderNo, rmbAmount);

        //请求微信
        String url = wxPayConfigBean.isSandbox()?TencentApiConstants.WX_REDPACKET_URL_SX :TencentApiConstants.WX_REDPACKET_URL;
        String xmlStr = WXPayUtil.mapToXml(params);
        log.info("发送参数：{}",xmlStr);
        String resultXml = HttpUtils.postData(url, xmlStr,TencentApiConstants.MCH_ID,TencentApiConstants.CERT_URL );
        log.info("发送红包结果：{}",resultXml);

        /*resultXml = "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[发放成功.]]></return_msg><result_code><![CDATA[SUCCESS]]></result_code>" +
                "<err_code><![CDATA[0]]></err_code><err_code_des><![CDATA[发放成功.]]></err_code_des><mch_billno><![CDATA["+orderNo+"]]></mch_billno>" +
                "<mch_id>1492556692</mch_id><wxappid><![CDATA[wx52100139f9d474b8]]></wxappid><re_openid><![CDATA["+openid+"]]></re_openid>" +
                "<total_amount>"+ rmbAmount + "</total_amount></xml>";
*/
        //解析结果
        Map<String, String> map = WXPayUtil.xmlToMap(resultXml);
        if (!map.isEmpty()){
            RedpacketResult resultDto = new RedpacketResult();
            String returnCode = map.get("return_code");
            resultDto.setReturnCode(returnCode);

            if (StringUtils.isNotBlank(returnCode) && Constants.STR_SUCCESS.equals(returnCode)){
                //请求成功
                String resultCode = map.get("result_code");
                resultDto.setResultCode(resultCode);
                String errCode = map.get("err_code");
                resultDto.setErrCode(errCode);
                String mchBillno = map.get("mch_billno");
                resultDto.setMchBillno(mchBillno);
                String mchId = map.get("mch_id");
                resultDto.setMchId(mchId);
                String wxappid = map.get("wxappid");
                resultDto.setWxappid(wxappid);
                String reOpenid = map.get("re_openid");
                resultDto.setReOpenid(reOpenid);
                String totalAmount = map.get("total_amount");
                resultDto.setTotalAmount(Integer.valueOf(totalAmount));

                if(StringUtils.isNotBlank(resultCode) && Constants.STR_SUCCESS.equals(resultCode)){
                    //发送成功
                    String sendListid = map.get("send_listid");
                    resultDto.setSendListid(sendListid);

                }else {
                    //发送失败
                    String errCodeDes = map.get("err_code_des");
                    resultDto.setErrCodeDes(errCodeDes);
                }
            }
            resultDto.setReturnMsg(map.get("return_msg"));

            return resultDto;
        }

        return null;
    }

    public Map<String,String> getParams(String openid, String orderNo, Integer rmbAmount) {
        Map<String,String> pramsMap = new HashMap<>();

        pramsMap.put("nonce_str",WXPayUtil.generateNonceStr());//随机字符串
        pramsMap.put("mch_billno",orderNo);//商户订单号
        pramsMap.put("mch_id", TencentApiConstants.MCH_ID);//商户号
        pramsMap.put("wxappid",TencentApiConstants.FREE_APP_ID);//公众账号appid
        pramsMap.put("send_name",TencentApiConstants.MCH_NAME);//商户名称
        pramsMap.put("re_openid",openid);//用户openid
        pramsMap.put("total_amount",rmbAmount+"");//付款金额
        pramsMap.put("total_num","1");//红包发放总人数
        pramsMap.put("wishing", "免费阅读，领红包。");//红包祝福语
        pramsMap.put("client_ip", getIp());//ip
        pramsMap.put("act_name","爱读书，更爱红包" );//活动名称
        pramsMap.put("remark", "看的越多，赚的越多");//备注
        pramsMap.put("scene_id",TencentApiConstants.PRODUCT_3);//场景id

        //签名
        try {
            String apiKey = wxPayConfigBean.isSandbox()?getsignkey(TencentApiConstants.MCH_ID,TencentApiConstants.API_KEY):TencentApiConstants.API_KEY;
            String sign = WXPayUtil.generateSignature(pramsMap,apiKey ,com.only.tech.payment.wxsdk.WXPayConstants.SignType.MD5);

            pramsMap.put("sign",sign.toUpperCase());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pramsMap;
    }

    /**
     * 沙箱密钥
     * @param mchId
     * @return
     */
    public static String getsignkey(String mchId,String apiKey) {

        try {
            Map<String,String> paramsMap = new HashMap<>();
            paramsMap.put("mch_id",mchId);
            paramsMap.put("nonce_str",WXPayUtil.generateNonceStr());
            String sign = WXPayUtil.generateSignature(paramsMap,apiKey , com.only.tech.payment.wxsdk.WXPayConstants.SignType.MD5);
            paramsMap.put("sign",sign);
            String xml = WXPayUtil.mapToXml(paramsMap);
            String resultXml = HttpUtils.post(TencentApiConstants.WX_GETSIGNKEY_URL, xml);
            Map<String, String> map = WXPayUtil.xmlToMap(resultXml);
            String returnCode = map.get("return_code");
            if (StringUtils.isNotBlank(returnCode) && Constants.STR_SUCCESS.equals(returnCode)){
                String sandboxSignkey = map.get("sandbox_signkey");
                return sandboxSignkey;
            }
            log.error("沙箱密钥查询错误：{}",resultXml);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public String getIp() {
        InetAddress ia=null;
        try {
            ia=ia.getLocalHost();
            String localip=ia.getHostAddress();
            return localip;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    /**
     * 查询红包发送结果
     * @param orderNo
     * @return
     */
    public RedpacketCheckResult sendCheck(String orderNo) throws Exception {
        //组织参数
        Map<String,String> paramsMap = new HashMap<>();
        paramsMap.put("mch_id",WXPayConstants.MCH_ID);
        paramsMap.put("nonce_str",WXPayUtil.generateNonceStr());
        paramsMap.put("mch_billno",orderNo);
        paramsMap.put("appid",WXPayConstants.FREE_APP_ID);
        paramsMap.put("bill_type","MCHT");
        String apiKey = wxPayConfigBean.isSandbox()?getsignkey(TencentApiConstants.MCH_ID,TencentApiConstants.API_KEY):TencentApiConstants.API_KEY;
        String sign = WXPayUtil.generateSignature(paramsMap,apiKey ,com.only.tech.payment.wxsdk.WXPayConstants.SignType.MD5);
        paramsMap.put("sign",sign);


        //请求微信
        String xmlStr =  WXPayUtil.mapToXml(paramsMap);
        log.info("检查红包状态参数：{}",xmlStr);
        String url = wxPayConfigBean.isSandbox()?TencentApiConstants.WX_REDPACKET_CHECK_URL_SX :TencentApiConstants.WX_REDPACKET_CHECK_URL;
        String resultXml = HttpUtils.postData(url, xmlStr,TencentApiConstants.MCH_ID,TencentApiConstants.CERT_URL );

        log.info("检查红包状态结果：{}",resultXml);

        /*resultXml = "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg><result_code><![CDATA[SUCCESS]]></result_code>" +
                "<err_code><![CDATA[SUCCESS]]></err_code><err_code_des><![CDATA[OK]]></err_code_des><mch_billno><![CDATA["+orderNo+"]]></mch_billno>" +
                "<mch_id><![CDATA[11475856]]></mch_id><detail_id><![CDATA[10000417012016080830956240040]]></detail_id><status><![CDATA[RECEIVED]]></status>" +
                "<send_type><![CDATA[ACTIVITY]]></send_type><hb_type><![CDATA[NORMAL]]></hb_type><total_num>1</total_num><total_amount>100</total_amount>" +
                "<send_time><![CDATA[2016-08-08 21:49:22]]></send_time><hblist><hbinfo><openid><![CDATA[oHkLxtzmyHXX6FW_cAWo_orTSRXs]]></openid><amount>100</amount>" +
                "<rcv_time><![CDATA[2016-08-08 21:49:46]]></rcv_time></hbinfo></hblist></xml>";*/

        //解析结果
        Map<String, Object> map = DataConvertUtil.xml2map(resultXml);
        if (!map.isEmpty()) {
            RedpacketCheckResult result = new RedpacketCheckResult();
            String returnCode = map.get("return_code").toString();
            result.setReturnCode(returnCode);
            String returnMsg = map.get("return_msg").toString();
            result.setReturnMsg(returnMsg);
            if (StringUtils.isNotBlank(returnCode) && Constants.STR_SUCCESS.equals(returnCode)){
                String resultCode = map.get("result_code").toString();
                result.setResultCode(resultCode);
                if (StringUtils.isNotBlank(resultCode) && Constants.STR_SUCCESS.equals(resultCode)){
                    Object mchBillno = map.get("mch_billno").toString();
                    result.setMchBillno(mchBillno != null? mchBillno.toString():"");
                    Object mchId = map.get("mch_id");
                    result.setMchId(mchId != null?mchId.toString():null);
                    Object detailId = map.get("detail_id");
                    result.setDetailId(detailId != null? detailId.toString():null);
                    Object status = map.get("status");
                    result.setStatus(status != null? status.toString():null);
                    Object sendType = map.get("send_type");
                    result.setSendType(sendType != null? sendType.toString():null);
                    Object hbType = map.get("hb_type");
                    result.setHbType(hbType != null? hbType.toString():null);
                    Object totalNum = map.get("total_num");
                    result.setTotalNum(totalNum != null? Integer.valueOf(totalNum.toString()):null);
                    Object totalAmount = map.get("total_amount");
                    result.setTotalAmount(totalAmount != null? Integer.valueOf(totalAmount.toString()):null);
                    Object reason = map.get("reason");
                    result.setReason(reason != null? reason.toString():"");
                    Object sendTime = map.get("send_time");
                    result.setSendTime(sendTime != null? sendTime.toString():null);
                    Object refundTime = map.get("refund_time");
                    result.setRefundTime(refundTime != null? refundTime.toString():null);
                    Object refundAmount = map.get("refund_amount");
                    result.setRefundAmount(refundAmount != null?Integer.valueOf(refundAmount.toString()):null);
                    Object wishing = map.get("wishing");
                    result.setWishing(wishing != null? wishing.toString():null);
                    Object remark = map.get("remark");
                    result.setRemark(remark != null? remark.toString(): null);
                    Object actName = map.get("act_name");
                    result.setActName(actName != null?actName.toString():null);
                    List<Map<String,Object>> hblist = (List<Map<String,Object>>)map.get("hblist");
                    result.setHblist(hblist);

                }else {
                    String errCode = map.get("err_code").toString();
                    result.setErrCode(errCode);
                    result.setErrCodeDes(map.get("err_code_des").toString());
                }
            }
            return result;
        }

        return null;
    }


}
