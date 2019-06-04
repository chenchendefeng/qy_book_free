package com.only.tech.user.common.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

/**
 * http请求工具类
 * 
 * @author xiaoshiyilang
 * @date 2018/10/17
 * @version 1.0
 */
public class HttpUtils {

	private static final Logger LOGGER = Logger.getLogger(HttpUtils.class);

	/**
	 * post请求
	 * 
	 * @param url
	 * @param jsonString
	 * @return
	 */
	public static String httpPost(String url, String jsonString) {
		String result = null;
		CloseableHttpClient httpClient =  HttpClients.createDefault();
		/*if(url.contains("https")){
			httpClient = SSLClient.createSSLClientDefault();
		}else{
			httpClient = HttpClients.createDefault();
		}*/
		HttpPost post = new HttpPost(url);
		CloseableHttpResponse httpResponse = null;
		try {
			post.setEntity(new ByteArrayEntity(jsonString.getBytes("UTF-8")));
			httpResponse = httpClient.execute(post);
			if (httpResponse != null && httpResponse.getStatusLine().getStatusCode() == 200) {
				result = EntityUtils.toString(httpResponse.getEntity(), "utf-8");
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("<---HTTP POST 请求报错，URL:" + url, e);
		} finally {
			releaseResources(httpClient, httpResponse);
		}
		return null;
	}


	/**
	 * post请求
	 * @param url
	 * @param data
	 * @return
	 */
	public static String post(String url, String data) {

		try {
			URL url2 = new URL(url);
			HttpURLConnection http = (HttpURLConnection) url2.openConnection();

			http.setRequestMethod("POST");
			http.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			http.setDoOutput(true);
			http.setDoInput(true);
			System.setProperty("sun.net.client.defaultConnectTimeout", "30000");// 连接超时30秒
			System.setProperty("sun.net.client.defaultReadTimeout", "30000"); // 读取超时30秒

			http.connect();
			if (data != null) {
				OutputStream os = http.getOutputStream();
				os.write(data.getBytes("UTF-8"));// 传入参数
				os.flush();
				os.close();
			}

			InputStream is = http.getInputStream();
			int size = is.available();
			byte[] jsonBytes = new byte[size];
			is.read(jsonBytes);
			String message = new String(jsonBytes, "UTF-8");
			return message;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}


	/**
	 * post请求
	 *
	 * @param url
	 * @param map
	 * @return
	 */
	public static String postForm(String url, Map<String,Object> map) {
		String result = null;

		CloseableHttpClient httpClient =  HttpClients.createDefault();

		HttpPost post = new HttpPost(url);
		CloseableHttpResponse httpResponse = null;

		try {
			MultipartEntityBuilder entityBuilder = MultipartEntityBuilder.create();
			for (String key : map.keySet()) {
				Object value = map.get(key);
				StringBody comment = new StringBody(value.toString(), ContentType.TEXT_PLAIN);
				entityBuilder.addPart(key,comment);
			}
			HttpEntity entity = entityBuilder.build();
			post.setEntity(entity);
			//发送请求，返回结果
			httpResponse = httpClient.execute(post);
			if (httpResponse != null && httpResponse.getStatusLine().getStatusCode() == 200) {
				result = EntityUtils.toString(httpResponse.getEntity(), "utf-8");
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("<---HTTP POST 请求报错，URL:" + url, e);
		} finally {
			releaseResources(httpClient, httpResponse);
		}
		return result;
	}

	/**
	 * 发送http get请求
	 * 
	 * @param getUrl
	 * @return
	 */
	public static String sendGetRequest(String getUrl) {
		StringBuffer sb = new StringBuffer();
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			URL url = new URL(getUrl);
			URLConnection urlConnection = url.openConnection();
			urlConnection.setAllowUserInteraction(false);
			isr = new InputStreamReader(url.openStream(), "UTF-8");
			br = new BufferedReader(isr);
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			LOGGER.error("http get 请求出错", e);
		} finally {
			try {
				if (isr != null) {
					isr.close();
				}
				if (br != null) {
					br.close();
				}
			} catch (Exception e) {
				LOGGER.error("关闭流出错", e);
			}
		}
		return sb.toString();
	}

	/**
	 * 请求url下载字节数组（get请求）
	 * 
	 * @param url
	 * @return
	 */
	public static byte[] download(String url) {

		byte[] result = null;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try {
			LOGGER.info("下载图片url=" + url);
			HttpGet httpGet = new HttpGet(url);
			// 设置请求和传输超时时间
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(30000).setConnectTimeout(10000)
					.build();
			httpGet.setConfig(requestConfig);

			HttpResponse response = httpClient.execute(httpGet);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				result = EntityUtils.toByteArray(entity);
			}
			httpGet.abort();
		} catch (Exception e) {
			LOGGER.error("HttpClient请求出错！", e);
		} finally {
			try {
				httpClient.close();
			} catch (IOException e) {
				LOGGER.error("关闭CloseableHttpClient异常！", e);
			}
		}
		return result;
	}

	/**
	 * 描述：get方式请求
	 * 
	 * @param url
	 * @return
	 * @throws Exception
	 */
	public static String httpGetConnect(String url) throws Exception {
		return httpGetConnect(url, "UTF-8");
	}

	/**
	 * 描述：get方式请求
	 * 
	 * @param url
	 * @param encoding
	 * @return
	 * @throws Exception
	 */
	public static String httpGetConnect(String url, String encoding){
		String result = null;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet get = new HttpGet(url);
		CloseableHttpResponse httpResponse = null;
		try {
			httpResponse = httpClient.execute(get);
			if (httpResponse != null && httpResponse.getStatusLine().getStatusCode() == 200) {
				result = EntityUtils.toString(httpResponse.getEntity(), encoding);
			}
			return result;
		} catch (Exception e) {
			LOGGER.error("<---HTTP POST 请求报错，URL:" + url, e);
		} finally {
			releaseResources(httpClient, httpResponse);
		}
		return null;
	}

	private static void releaseResources(CloseableHttpClient httpClient, CloseableHttpResponse httpResponse) {
		try {
			httpClient.close();
			if (httpResponse != null) {
				httpResponse.close();
			}
		} catch (IOException e) {
			LOGGER.error("close http client error!!", e);
		}
	}
}
