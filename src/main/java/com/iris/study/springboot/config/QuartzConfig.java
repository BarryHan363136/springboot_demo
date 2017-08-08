package com.iris.study.springboot.config;

import java.io.IOException;
import java.util.Properties;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {

    /** Spring 容器 */
    protected ApplicationContext ctx;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }

    @Bean
    public Scheduler scheduler() throws IOException, SchedulerException {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory(quartzProperties());
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();
        return scheduler;
    }

    /**
     * 设置quartz属性
     * @throws IOException
     * 2016年10月8日下午2:39:05
     */
    public Properties quartzProperties() throws IOException {
        Properties prop = new Properties();
        prop.put("quartz.scheduler.instanceName", "ServerScheduler");
        prop.put("org.quartz.scheduler.instanceId", "AUTO");
        prop.put("org.quartz.scheduler.skipUpdateCheck", "true");
        prop.put("org.quartz.scheduler.instanceId", "NON_CLUSTERED");
        prop.put("org.quartz.scheduler.jobFactory.class", "org.quartz.simpl.SimpleJobFactory");
        prop.put("org.quartz.threadPool.class", "org.quartz.simpl.SimpleThreadPool");
        prop.put("org.quartz.threadPool.threadCount", "5");

        //prop.put("org.quartz.jobStore.class", "org.quartz.impl.jdbcjobstore.JobStoreTX");
        //prop.put("org.quartz.jobStore.driverDelegateClass", "org.quartz.impl.jdbcjobstore.StdJDBCDelegate");
        //prop.put("org.quartz.jobStore.dataSource", "quartzDataSource");
        //prop.put("org.quartz.jobStore.tablePrefix", "QRTZ_");
        //prop.put("org.quartz.jobStore.isClustered", "true");
        //prop.put("org.quartz.dataSource.quartzDataSource.driver", "com.mysql.jdbc.Driver");
        //prop.put("org.quartz.dataSource.quartzDataSource.URL", "jdbc:mysql://localhost:3306/demo-schema");
        //prop.put("org.quartz.dataSource.quartzDataSource.user", "root");
        //prop.put("org.quartz.dataSource.quartzDataSource.password", "123456");
        //prop.put("org.quartz.dataSource.quartzDataSource.maxConnections", "10");
        return prop;
    }
}