package com.atguigu.sprongcloud.service.impl;

import com.atguigu.springcloud.entities.Dept;
import com.atguigu.sprongcloud.dao.DeptDao;
import com.atguigu.sprongcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;
    @Override
    public boolean add(Dept dept) {
        return deptDao.addDept(dept);
    }

    @Override
    public Dept get(Long id) {
        return deptDao.findById(id);
    }

    @Override
    public List<Dept> list() {
        return deptDao.findAll();
    }

    @Override
    public Boolean insertDept(String name) {
        return deptDao.insertDept(name);
    }
}
