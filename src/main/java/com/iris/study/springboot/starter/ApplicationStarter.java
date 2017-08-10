package com.iris.study.springboot.starter;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.CharacterEncodingFilter;
import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;


/**
 * TaskApplication [spring boot] 主方法
 *
 * 启动方式，右键->run/debug->Spring Boot App
 *
 * @author chongwenjun
 *
 */
@SpringBootApplication
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

    // 用于处理编码问题
    @Bean
    public Filter characterEncodingFilter() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return characterEncodingFilter;
    }

    // 文件上传限制
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        // 设置文件大小限制 ,超出设置页面会抛出异常信息，
        // 这样在文件上传的地方就需要进行异常信息的处理了;
        factory.setMaxFileSize("2560KB"); // KB,MB
        /// 设置总上传数据总大小
        factory.setMaxRequestSize("5120KB");
        // Sets the directory location where files will be stored.
        // factory.setLocation("路径地址");
        return factory.createMultipartConfig();
    }

    //文件下载
    @Bean
    public HttpMessageConverters restFileDownloadSupport() {
        ByteArrayHttpMessageConverter arrayHttpMessageConverter = new ByteArrayHttpMessageConverter();
        return new HttpMessageConverters(arrayHttpMessageConverter);
    }

//    @Bean
//    protected AsyncRestTemplate asyncRestTemplate() throws Exception {
//        SSLIOSessionStrategy strategy = new SSLIOSessionStrategy(
//                SSLContext.getDefault(),
//                SSLSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER
//        );
//        Registry<SchemeIOSessionStrategy> registry = RegistryBuilder.<SchemeIOSessionStrategy>create()
//                .register("http", NoopIOSessionStrategy.INSTANCE)
//                .register("https", strategy)
//                .build();
//        PoolingNHttpClientConnectionManager connManager = new PoolingNHttpClientConnectionManager(
//                new DefaultConnectingIOReactor(),
//                registry
//        );
//        CloseableHttpAsyncClient httpClient = HttpAsyncClientBuilder
//                .create()
//                .setConnectionManager(connManager)
//                .build();
//        AsyncClientHttpRequestFactory requestFactory = new HttpComponentsAsyncClientHttpRequestFactory(httpClient);
//        return new AsyncRestTemplate(requestFactory);
//    }


    public static void main(String[] args) {
        SpringApplication.run(ApplicationStarter.class, args);
    }

}
