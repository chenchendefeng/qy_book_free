package ooh.chaos.service;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.common.utils.IOUtils;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import ooh.chaos.configuration.OSSConfig;
import ooh.chaos.util.DateFormatUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.net.URL;
import java.util.Date;

@Component
public class OSSService {

    private static final Logger log = LoggerFactory.getLogger(OSSService.class);

    @Autowired
    private OSSClient client;

    @Autowired
    private OSSConfig config;

    public boolean saveContent(long cbid, long ccid, String content) {
        try {
            ObjectMetadata meta = new ObjectMetadata();
            meta.setContentType("text/plain");
            client.putObject(config.getBucketName(), cbid + "/" + ccid + ".txt", new ByteArrayInputStream(content.getBytes()), meta);
            return true;
        } catch (OSSException e) {
            log.error("oss 错误：",e);
        } catch (ClientException e) {
            log.error("oss 错误：",e);
        }
        return false;
    }

    public void deleteContent(long cbid, long ccid) {
        client.deleteObject(config.getBucketName(), cbid + "/" + ccid + ".txt");
    }

    public String getContent(long cbid, long ccid) {

        String result = "";
        try {
            result = new String(IOUtils.readStreamAsByteArray(client.getObject(config.getBucketName(), cbid + "/" + ccid + ".txt").getObjectContent()),
                    "utf-8");
        } catch (Exception e) {
            log.error("OSS get content error, cbid :[{}], ccid :[{}]", cbid, ccid);
        }
        return result;
    }

    public boolean checkContentExist(long cbid, long ccid) {
        return client.doesObjectExist(config.getBucketName(), cbid + "/" + ccid + ".txt");
    }

    public String getChapterUrl(String key, Integer minute) {

        Date now = new Date();
        Date expiration = DateFormatUtil.addMinute(now, minute);

        URL url = this.client.generatePresignedUrl(config.getBucketName(), key, expiration);
        return url.toString();
    }

}
