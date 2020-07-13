package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
//EurekaServer服务器端启动类，接受其他微服务注册进来
@EnableEurekaServer
public class Config_Git_EurekaServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(Config_Git_EurekaServiceApplication.class,args);
    }
}
