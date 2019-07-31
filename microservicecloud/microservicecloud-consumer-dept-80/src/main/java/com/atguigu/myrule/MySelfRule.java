package com.atguigu.myrule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;

@Configuration
public class MySelfRule {
       @Bean
       public IRule myRule() {
//           return new RandomRule();//Ribbon默认时轮询
           return new RandomRule_ZY();
       }
    
}
