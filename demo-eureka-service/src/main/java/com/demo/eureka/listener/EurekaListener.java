package com.demo.eureka.listener;

import com.netflix.discovery.shared.Applications;
import com.netflix.eureka.EurekaServerContextHolder;
import com.netflix.eureka.registry.PeerAwareInstanceRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRegisteredEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRenewedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Title: EurekaListener
 * @Description: 注册中心服务监听配置
 * @author: 叶要强
 * @date: 2018/12/3 15:20
 * @Copyright: 2018 Inc. All rights reserved.
 */
@Slf4j
@Configuration
@EnableScheduling
public class EurekaListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        // 1.服务挂掉事件
        if (event instanceof EurekaInstanceCanceledEvent) {
            EurekaInstanceCanceledEvent instanceCanceledEvent = (EurekaInstanceCanceledEvent) event;
            // 获取节点信息
            PeerAwareInstanceRegistry registry = EurekaServerContextHolder.getInstance().getServerContext().getRegistry();
            Applications applications = registry.getApplications();
            applications.getRegisteredApplications().forEach((registryApplication) -> {
                registryApplication.getInstances().forEach((instance) -> {
                    if (instance.getInstanceId().equals(instanceCanceledEvent.getServerId())) {
                        log.debug("[EurekaListener.onApplicationEvent] [服务：{} 已停止！]", instance.getAppName());
                    }
                });
            });
        }
        // 2.服务注册事件
        if (event instanceof EurekaInstanceRegisteredEvent) {
            EurekaInstanceRegisteredEvent instanceRegisteredEvent = (EurekaInstanceRegisteredEvent) event;
            if (instanceRegisteredEvent.getInstanceInfo() != null) {
                log.debug("[EurekaListener.onApplicationEvent] [服务：{} 注册成功！]", instanceRegisteredEvent.getInstanceInfo().getAppName());
            }
        }
        // 3.服务心跳监听事件
        if (event instanceof EurekaInstanceRenewedEvent) {
            EurekaInstanceRenewedEvent instanceRenewedEvent = (EurekaInstanceRenewedEvent) event;
            if (instanceRenewedEvent.getInstanceInfo() != null) {
                log.debug("[EurekaListener.onApplicationEvent] [心跳检测服务：{} 注册成功！]", instanceRenewedEvent.getInstanceInfo().getAppName());
            }
        }
    }
}
