package ooh.chaos.configuration;

import com.aliyun.oss.OSSClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class OSSPicConfig {
    String endpoint = "http://oss-cn-shenzhen.aliyuncs.com";
    String accessKeyId = "LTAI8bT0KqC23o51";
    String accessKeySecret = "qq2nBjdWjOYM8vQGAQVBu7F3hlsk7i";
    String bucketName = "qy-pic";

    public OSSPicConfig() {
    }

    @Bean
    public OSSClient getClient() {
        return new OSSClient(this.endpoint, this.accessKeyId, this.accessKeySecret);
    }

    public String getBucketName() {
        return this.bucketName;
    }
}
