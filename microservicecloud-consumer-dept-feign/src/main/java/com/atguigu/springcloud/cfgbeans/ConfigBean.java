package com.atguigu.springcloud.cfgbeans;

import com.netflix.loadbalancer.*;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Configuration
//boot优化spring     applicationContext.xml-->@Configuration
public class ConfigBean {
    @Bean
    @LoadBalanced  //Spring Cloud Ribbon是基于Netfix Ribbon是基于Netflix Ribbon实现的一套客户端    负载均衡工具
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    //自定义Ribbon算法
    @Bean
    public IRule myRule(){
        /*
        轮询
        return new RoundRobinRule();
         */

        return new RandomRule();        //随机

        /*
        会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，
        而且还有并发的连接数量超过阀值的服务，然后对剩余的服务列表按照
        轮询策略进行访问
        return new AvailabilityFilteringRule();
         */
        /*
        根据平均响应时间计算所有服务的权重，响应时间越快服务权重越大被选中的概率越高。
        刚启动时如果统计信息不足，则使用RoundRobinRule策略，等统计信息足够，会切换到
        WeightedResponseTimeRule
        return new WeightedResponseTimeRule();
         */
        /*
        先按照RounfRobinRule的策略获取服务，如果获取服务失败则在指定时间内会进行重试，获取可用的服务
        return new RetryRule()；
         */
        /*
        会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，然后选择一个并发量很小的服务
        return new BestAvailableRule();
         */
        /*
        默认规则，符合判断server所在区域的性能和server的可用性选择服务器
        retuen new ZoneAvoidanceRule();
         */
    }
}
//    @Bean
//    public RestTemplate getRestTemplate(){
//        return new RestTemplate();
//    }
//    <bean id="userService" class="com.atguigu.tmall.UserServiceImpl">
