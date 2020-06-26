package com.atguigu.sprongcloud.service;

import com.atguigu.springcloud.entities.Dept;

import java.util.List;

public interface DeptService {

    boolean add(Dept dept);

    Dept get(Long id);

    List<Dept> list();

    Boolean insertDept(String name);
}
