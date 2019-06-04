package com.only.tech.payment.service.push.hanlder;

import com.only.tech.payment.service.push.common.PushConstants;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Service
@Slf4j
public class PushClient {
	

	// The user agent
	private final String USER_AGENT = "Mozilla/5.0";

	// This object is used for sending the post request to Umeng
	private HttpClient client = HttpClientBuilder.create().build();
	
	/**
	 * 
	 * operateTag:(友盟自定义标签的操作-增删改查)
	 *
	 * @param deviceToken
	 * @param operate
	 * @throws Exception
	 *             设定文件
	 * @return void DOM对象
	 * @throws @since
	 *             CodingExample Ver 1.1
	 */
	public String commonRequestApi(String postBody,String url) throws Exception {
		log.info("commonRequestApi url={},postBody={}",url,postBody);
		String sign = DigestUtils.md5Hex(("POST" + url + postBody + PushConstants.APP_MASTER_SECRET).getBytes("utf8"));
		url = url + "?sign=" + sign;
		HttpPost post = new HttpPost(url);
		post.setHeader("User-Agent", USER_AGENT);
		StringEntity se = new StringEntity(postBody, "UTF-8");
		post.setEntity(se);
		// Send the post request and get the response
		HttpResponse response = client.execute(post);
		log.info("Response Code : " + response.getStatusLine().getStatusCode());
		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		log.info("commonRequestApi url={},result={}",url,result.toString());
		return result.toString();
	}

}
