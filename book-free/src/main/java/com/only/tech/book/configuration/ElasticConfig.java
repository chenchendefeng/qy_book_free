package com.only.tech.book.configuration;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.xpack.client.PreBuiltXPackTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import javax.annotation.PostConstruct;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.only.tech.book.doc")
public class ElasticConfig {
    @PostConstruct
    void init() {
        System.setProperty("es.set.netty.runtime.available.processors", "false");
    }

    @Value("${spring.data.elasticsearch.cluster-name}")
    private String cluster_name;

    @Value("${spring.data.elasticsearch.cluster-nodes-host}")
    private String host;
    @Value("${spring.data.elasticsearch.cluster-nodes-port}")
    private int port;
    @Value("${spring.data.elasticsearch.xpack.security.user}")
    private String xpack_security_user;

    @Bean
    public TransportClient transportClient() throws UnknownHostException {
        TransportClient client = new PreBuiltXPackTransportClient(Settings.builder()
                .put("cluster.name", cluster_name)
                .put("xpack.security.user", xpack_security_user)
                .build())
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(host), port));
        return client;
    }
}

