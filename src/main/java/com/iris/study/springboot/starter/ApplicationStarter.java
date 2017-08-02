package com.iris.study.springboot.starter;

import com.iris.study.springboot.common.util.DefaultProfileUtil;
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
import org.springframework.core.env.Environment;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

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
