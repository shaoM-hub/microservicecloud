package com.atguigu.springcloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
//boot优化spring     applicationContext.xml-->@Configuration
public class ConfigBean {
    @Bean
    @LoadBalanced  //Spring Cloud Ribbon是基于Netfix Ribbon是基于Netflix Ribbon实现的一套客户端    负载均衡工具
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
//    @Bean
//    public RestTemplate getRestTemplate(){
//        return new RestTemplate();
//    }
//    <bean id="userService" class="com.atguigu.tmall.UserServiceImpl">
