package com.only.tech.payment.wxsdk;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.only.tech.payment.common.constant.WXPayConstants;

@Configuration
@Component
public class WXPayConfig {
	 private byte[] certData;

	 public  WXPayConfig() throws Exception {
		ClassPathResource classPathResource = new ClassPathResource("/pay/wx/apiclient_cert.p12");
		InputStream certStream = classPathResource.getInputStream();
        this.certData = IOUtils.toByteArray(certStream);
        certStream.read(this.certData);
        certStream.close();
    }

     String getAppID() {
        return WXPayConstants.APP_ID;
    }

     String getMchID() {
        return WXPayConstants.MCH_ID;
    }

     String getKey() {
        return WXPayConstants.API_KEY;
    }
     InputStream getCertStream() {
        ByteArrayInputStream certBis = new ByteArrayInputStream(this.certData);
        return certBis;
    }

 	class MyDomain implements IWXPayDomain{

		@Override
		public void report(String domain, long elapsedTimeMillis, Exception ex) {
			// TODO Auto-generated method stub
		}

		@Override
		public DomainInfo getDomain(WXPayConfig config) {
			return new DomainInfo("api.mch.weixin.qq.com",true);
		}
	}

	IWXPayDomain getWXPayDomain() {
		return new MyDomain();
	}

    /**
     * HTTP(S) 连接超时时间，单位毫秒
     *
     * @return
     */
    public int getHttpConnectTimeoutMs() {
        return 6*1000;
    }

    /**
     * HTTP(S) 读数据超时时间，单位毫秒
     *
     * @return
     */
    public int getHttpReadTimeoutMs() {
        return 8*1000;
    }


    /**
     * 是否自动上报。
     * 若要关闭自动上报，子类中实现该函数返回 false 即可。
     *
     * @return
     */
    public boolean shouldAutoReport() {
        return true;
    }

    /**
     * 进行健康上报的线程的数量
     *
     * @return
     */
    public int getReportWorkerNum() {
        return 6;
    }


    /**
     * 健康上报缓存消息的最大数量。会有线程去独立上报
     * 粗略计算：加入一条消息200B，10000消息占用空间 2000 KB，约为2MB，可以接受
     *
     * @return
     */
    public int getReportQueueMaxSize() {
        return 10000;
    }

    /**
     * 批量上报，一次最多上报多个数据
     *
     * @return
     */
    public int getReportBatchSize() {
        return 10;
    }

}
