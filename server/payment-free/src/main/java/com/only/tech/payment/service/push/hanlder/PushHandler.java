package com.only.tech.payment.service.push.hanlder;

import com.only.tech.payment.common.utils.DateUtils;
import com.only.tech.payment.service.push.android.AndroidCustomizedcast;
import com.only.tech.payment.service.push.android.AndroidFilecast;
import com.only.tech.payment.service.push.android.AndroidGroupcast;
import com.only.tech.payment.service.push.android.AndroidUnicast;
import com.only.tech.payment.service.push.common.HandleTagType;
import com.only.tech.payment.service.push.common.PushConstants;
import com.only.tech.payment.service.push.dto.PushAndroidDto;
import com.only.tech.payment.service.push.dto.PushIOSDto;
import com.only.tech.payment.service.push.ios.IOSCustomizedcast;
import com.only.tech.payment.service.push.ios.IOSFilecast;
import com.only.tech.payment.service.push.ios.IOSGroupcast;
import com.only.tech.payment.service.push.ios.IOSUnicast;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PushHandler {

	@Autowired
	private PushClient client;

	/**
	 * 操作标签
	 * 
	 * @param deviceToken
	 * @param tag
	 * @param handle
	 * @throws Exception
	 */
	public String handleTag(String deviceToken, String tag, HandleTagType handle) throws Exception {
		// Construct the json string
		JSONObject tagJson = new JSONObject();
		log.info("operateTag deviceToken={},operate={},tag={}",deviceToken,handle.getValue(),tag);
		tagJson.put("appkey", PushConstants.APP_KEY);
		tagJson.put("timestamp", DateUtils.getCurrentTimestamp());
		tagJson.put("device_tokens", deviceToken);
		String url = null;
		if (tag != null) { // clear 和 list 接口不需要tag参数
			tagJson.put("tag", tag);
		}
		url = PushConstants.host + PushConstants.tagPath + handle.getValue();

		return client.commonRequestApi(tagJson.toString(),url);
	}
	
	/**
	 * 查询状态
	 * @param taskId
	 * @return
	 * @throws Exception
	 */
	public String queryStatus(String taskId) throws Exception
	{
		JSONObject taskJson = new JSONObject();
		log.info("queryStatus taskId={}",taskId);
		taskJson.put("appkey", PushConstants.APP_KEY);
		taskJson.put("timestamp", DateUtils.getCurrentTimestamp());
		taskJson.put("task_id", taskId);
		String url = PushConstants.host + PushConstants.queryPath;

		return client.commonRequestApi(taskJson.toString(),url);
	}
	
	
	/**
	 * 撤销
	 * @param taskId
	 * @return
	 * @throws Exception
	 */
	public String cancelTask(String taskId) throws Exception
	{
		JSONObject taskJson = new JSONObject();
		log.info("queryStatus taskId={}",taskId);
		taskJson.put("appkey", PushConstants.APP_KEY);
		taskJson.put("timestamp", DateUtils.getCurrentTimestamp());
		taskJson.put("task_id", taskId);
		String url = PushConstants.host + PushConstants.cancelPath;
		return client.commonRequestApi(taskJson.toString(),url);
	}
	
	/**
	 * 上传
	 * @param contents
	 * @return
	 * @throws Exception
	 */
	public String uploadContents(String contents) throws Exception {
		// Construct the json string
		JSONObject uploadJson = new JSONObject();
		uploadJson.put("appkey", PushConstants.APP_KEY);
		uploadJson.put("timestamp", DateUtils.getCurrentTimestamp());
		uploadJson.put("content", contents);
		// Construct the request
		String url = PushConstants.host + PushConstants.uploadPath;
		String postBody = uploadJson.toString();
		return client.commonRequestApi(postBody, url);
	}
	/**
	 * 根据androidPush类型发送push
	 * @param detail
	 * @param productMode
	 * @param androidPush
	 * @return
	 * @throws Exception
	 */
	public String sendAndroid(PushAndroidDto detail, boolean productMode, AndroidNotification androidPush)
			throws Exception {
		if(androidPush instanceof AndroidCustomizedcast || androidPush instanceof AndroidFilecast)
		{
			String content = detail.getContent();
			if(StringUtils.isEmpty(content))
			{
				((AndroidCustomizedcast) androidPush).setAlias(detail.getAlias(), detail.getAliasType());
			}
			else
			{
				String fileId = uploadContents(detail.getContent());
				if(androidPush instanceof AndroidCustomizedcast)
				{
					((AndroidCustomizedcast) androidPush).setFileId(fileId, detail.getAliasType());
				}
				else
				{
					((AndroidFilecast) androidPush).setFileId(fileId);
				}
			}
		}
		if(androidPush instanceof AndroidGroupcast)
		{
			((AndroidGroupcast) androidPush).setFilter(detail.getFilterJson());
		}
		if(androidPush instanceof AndroidUnicast)
		{
			((AndroidUnicast) androidPush).setDeviceToken(detail.getDeviceToken());
		}
		androidPush.setTicker(detail.getTicker());// 通知栏提示文字
		androidPush.setTitle(detail.getTitle());
		androidPush.setText(detail.getText());
		androidPush.goAppAfterOpen();
		androidPush.setStartTime(detail.getStartTime());
		androidPush.setDisplayType(detail.getDisPlayType());
		androidPush.setProductionMode(productMode);
		androidPush.setExtra(detail.getExtra());
		androidPush.setPredefinedKeyValue("timestamp", DateUtils.getCurrentTimestamp());
		String url = PushConstants.host + PushConstants.pushPath;
		String postBody = androidPush.getPostBody();
		String sendresult =  client.commonRequestApi(postBody,url);
		log.info("sendAndroid sendresult={}",sendresult);
		return sendresult;
	}

	public String sendIOS(PushIOSDto detail, boolean productMode, IOSNotification iosPush) throws Exception {
		if(iosPush instanceof IOSCustomizedcast || iosPush instanceof IOSFilecast)
		{
			String content = detail.getContent();
			if(StringUtils.isEmpty(content))
			{
				((IOSCustomizedcast) iosPush).setAlias(detail.getAlias(), detail.getAliasType());
			}
			else
			{
				String fileId = uploadContents(detail.getContent());
				if(iosPush instanceof IOSCustomizedcast)
				{
					((IOSCustomizedcast) iosPush).setFileId(fileId, detail.getAliasType());
				}
				else
				{
					((IOSFilecast) iosPush).setFileId(fileId);
				}
			}
		}
		if(iosPush instanceof IOSGroupcast)
		{
			((IOSGroupcast) iosPush).setFilter(detail.getFilterJson());
		}
		if(iosPush instanceof IOSUnicast)
		{
			((IOSUnicast) iosPush).setDeviceToken(detail.getDeviceToken());
		}
		iosPush.setAlert(detail.getAlert());
		iosPush.setBadge(detail.getBadge());
		iosPush.setSound(StringUtils.isEmpty(detail.getSound())?"default":detail.getSound());
		iosPush.setStart_time(detail.getStartTime());
		iosPush.setProductionMode(productMode);
		iosPush.setExtra(detail.getExtra());
		iosPush.setPredefinedKeyValue("timestamp", DateUtils.getCurrentTimestamp());
		String url = PushConstants.host + PushConstants.pushPath;
		String postBody = iosPush.getPostBody();
		String sendresult =  client.commonRequestApi(postBody,url);
		log.info("sendIOS sendresult={}",sendresult);
		return sendresult;
	}
	
}
