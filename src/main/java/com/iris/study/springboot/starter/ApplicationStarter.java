package com.iris.study.springboot.starter;

import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.apache.http.impl.nio.conn.PoolingNHttpClientConnectionManager;
import org.apache.http.impl.nio.reactor.DefaultConnectingIOReactor;
import org.apache.http.nio.conn.NoopIOSessionStrategy;
import org.apache.http.nio.conn.SchemeIOSessionStrategy;
import org.apache.http.nio.conn.ssl.SSLIOSessionStrategy;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.AsyncClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsAsyncClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.security.NoSuchAlgorithmException;

/**
 * TaskApplication [spring boot] 主方法
 *
 * 启动方式，右键->run/debug->Spring Boot App
 *
 * @author chongwenjun
 *
 */
@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages={"com.iris.study.springboot"})
@MapperScan(basePackages = "com.iris.study.springboot.mapper")
public class ApplicationStarter {
    /** 日志类 */
    private static final Logger logger = LoggerFactory.getLogger(ApplicationStarter.class);

    @Value("${http.rest.connection.connection-request-timeout}")
    private Integer httpConnectionRequestTimeout;

    @Value("${http.rest.connection.connect-timeout}")
    private Integer httpConnectionTimeout;

    @Value("${http.rest.connection.read-timeout}")
    private Integer httpConnectionReadTimeout;

    @Bean
    public RestTemplate restTemplate(){
        HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        httpRequestFactory.setConnectionRequestTimeout(httpConnectionRequestTimeout);
        httpRequestFactory.setConnectTimeout(httpConnectionTimeout);
        httpRequestFactory.setReadTimeout(httpConnectionReadTimeout);

        return new RestTemplate(httpRequestFactory);
    }

    @Bean
    protected AsyncRestTemplate asyncRestTemplate() throws Exception {
        SSLIOSessionStrategy strategy = new SSLIOSessionStrategy(
                SSLContext.getDefault(),
                SSLSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER
        );
        Registry<SchemeIOSessionStrategy> registry = RegistryBuilder.<SchemeIOSessionStrategy>create()
                .register("http", NoopIOSessionStrategy.INSTANCE)
                .register("https", strategy)
                .build();
        PoolingNHttpClientConnectionManager connManager = new PoolingNHttpClientConnectionManager(
                new DefaultConnectingIOReactor(),
                registry
        );
        CloseableHttpAsyncClient httpClient = HttpAsyncClientBuilder
                .create()
                .setConnectionManager(connManager)
                .build();
        AsyncClientHttpRequestFactory requestFactory = new HttpComponentsAsyncClientHttpRequestFactory(httpClient);
        return new AsyncRestTemplate(requestFactory);
    }


    public static void main(String[] args) {
//        SpringApplication app = new SpringApplication(ApplicationStarter.class);
//        DefaultProfileUtil.addDefaultProfile(app);
//        Environment env = app.run(args).getEnvironment();
//        SpringApplication.run(ApplicationStarter.class, args);
//        logger.info("\n----------------------------------------------------------\n\t" +
//                        "Application '{}' is running! Access URLs:\n\t" +
//                        "Local: \t\thttp://localhost:{}\n\t" +
//                        "----------------------------------------------------------",
//                env.getProperty("spring.application.name"),
//                env.getProperty("server.port"));
        SpringApplication.run(ApplicationStarter.class, args);
    }

}
