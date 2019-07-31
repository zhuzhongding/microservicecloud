package com.atguigu.springcloud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.atguigu.springcloud.entities.Dept;

@Mapper//springboot与mybatis整合，不能少的注解
public interface DeptDao {

    public boolean addDept(Dept dept);
    
    public Dept findById(Long id);
    
    public List<Dept> findAll();
    
}
