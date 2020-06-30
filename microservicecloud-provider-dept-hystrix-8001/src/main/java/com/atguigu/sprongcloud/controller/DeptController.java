package com.atguigu.sprongcloud.controller;

import com.atguigu.springcloud.entities.Dept;
import com.atguigu.sprongcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
    private DeptService service;

    @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
    //一旦调用服务方法失败并抛出了错误信息后，自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept add(@PathVariable("id") Long id){
        System.out.println("++++++++++Hystrix");
        Dept dept = this.service.get(id);
        if (null == dept){
            throw new RuntimeException("该ID:" + id + "没有对应的信息");
        }
        return dept;
    }

    public Dept processHystrix_Get(@PathVariable("id") Long id){
        return new Dept().setDepTno(id).setDName("该ID:" + id + "没有对应的信息，null--@HystrixCommand")
                .setDbSource("no this database in MySQL");
    }

    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    public List<Dept> list(){
        System.out.println("-------------Hystrix");
        return service.list();
    }

}
