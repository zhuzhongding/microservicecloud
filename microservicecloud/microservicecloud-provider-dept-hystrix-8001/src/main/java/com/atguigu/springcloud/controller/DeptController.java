package com.atguigu.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sun.tools.classfile.Annotation.element_value;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;
    
    @Autowired
    private DiscoveryClient client;
    
    @RequestMapping(value="/dept/add", method=RequestMethod.POST)
    public boolean add(@RequestBody Dept dept) {
        return deptService.add(dept);
    }
    
    @RequestMapping(value="/dept/get/{id}", method=RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept get(@PathVariable Long id) {
        Dept dept = this.deptService.get(id);
        if(null == dept) {
            throw new RuntimeException("该ID"+id+"没有对应的信息");
        }
        return dept;
    }
    
    public Dept processHystrix_Get(@PathVariable Long id) {
        Dept dept = new Dept();
        dept.setDeptno(id);
        dept.setDname("该ID"+id+"没有对应的信息，null--@HystrixCommand");
        dept.setDb_source("no this database in MYSQL");
        return dept;
    }
    
    @RequestMapping(value="/dept/list", method=RequestMethod.GET)
    public List<Dept> list() {
        return deptService.list();
    }
    
    @RequestMapping(value="/dept/discovery",method=RequestMethod.GET)
    public Object discovery() {
        List<String> list = client.getServices();
        System.out.println("***********"+list);
        List<ServiceInstance> srvList = client.getInstances("MICROSERVICECLOUD-DEPT");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId()+"\t"+element.getHost()+"\t"+element.getPort()+"\t"+element.getUri());
        }
        return this.client;
    }
    
}
