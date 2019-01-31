package com.demo.common.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class SendMessageConfig {

    @Value("${sendMessage.SMSTranId}")
    private String msgSMSTranId;

    @Value("${sendMessage.tokenClientId}")
    private String msgTokenClientId;

    @Value("${sendMessage.tokenClientSecret}")
    private String msgTokenClientSecret;

    @Value("${sendMessage.tokenTranId}")
    private String msgTokenTranId;

    @Value("${sendMessage.interfaceUrl}")
    private String preInterfaceUrl;

    @Value("${sendMessage.serverMd5Key}")
    private String preServMd5Key;

    @Value("${sendMessage.appId}")
    private String msgAppId;

}
