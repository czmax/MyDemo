package com.xxl.job.executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author xuxueli 2018-10-28 00:38:13
 */
@EnableEurekaClient
@SpringBootApplication
public class DemoXxlJobExecutorApplication {

	public static void main(String[] args) {
        SpringApplication.run(DemoXxlJobExecutorApplication.class, args);
	}

}