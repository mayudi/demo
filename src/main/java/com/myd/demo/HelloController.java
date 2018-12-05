package com.myd.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    /*@RequestMapping("/hello")
    public String hello(){
        return "hello";
    }*/

    @Autowired
    private RedisTemplate redisTemplate;


    @GetMapping("/hello")
    public String hello(){
        redisTemplate.opsForValue().set("admin","admin");
        return "测试";
    }

    @GetMapping("/get")
    public String get(){
        return redisTemplate.opsForValue().get("admin").toString();
    }

}
