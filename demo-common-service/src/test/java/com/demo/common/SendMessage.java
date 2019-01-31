package com.demo.common;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class SendMessage {

    public void sendMessage() {
        log.info("[Trans2lisServiceImpl.sendMessage][签单投保成功实时发送短信->开始]");
        Long startTime = System.currentTimeMillis();
        Map<String, Object> map = new HashMap<>();
        map.put("appntname", "");// 投保人姓名
        map.put("appntsex", "");// 投保人性别
        map.put("appntbankname", "");// 销售银行
        map.put("riskname", "");// 险种名称（取主险名称）
        map.put("sumprem", "");// 总保费
        map.put("hotline", "");// 客户服务热线
        map.put("phone", "");// 投保人电话(短信接收人电话)
        map.put("template_id", "");// 短信id
        map.put("require_send_time", "");// 发送时间
        map.put("template_name", "SMSTempId_1");//模板参数id
        map.put("BussinessNo", "");//保单号
        map.put("BussinessType", "1");//1代表保单号 2代表投保单号
        Long endTime = System.currentTimeMillis();
        log.info("[Trans2lisServiceImpl.sendMessage][签单投保成功实时发送短信->结束][耗时：{}秒]", (endTime - startTime) / 1000.0F);
    }
}

