package com.demo.eureka.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Order(value = 2)
public class MyStartupRunner2 implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        log.info("[MyStartupRunner2.run] [>>>>>>>>>>>>>>>服务启动执行，执行加载数据等操作 ② <<<<<<<<<<<<<]");
    }
}
