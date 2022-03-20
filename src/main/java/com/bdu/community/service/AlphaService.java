package com.bdu.community.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
@Scope("prototype")
public class AlphaService {
    public AlphaService() {
        System.out.println("实例化AlphaService");
    }
    //在构造器之后调用
    @PostConstruct
    public void init(){
        System.out.println("初始化AlphaService");
    }
    //销毁之前调用
    @PreDestroy
    public void destroy(){
        System.out.println("销毁AlphaService");
    }

}
