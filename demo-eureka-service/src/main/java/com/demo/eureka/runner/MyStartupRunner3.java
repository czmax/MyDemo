package com.demo.eureka.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Order(value = 1)
public class MyStartupRunner3 implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        log.info("[MyStartupRunner3.run] [>>>>>>>>>>>>>>>服务启动执行，执行加载数据等操作 ③ <<<<<<<<<<<<<]");
    }
}
