package com.myd.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

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

    @RequestMapping("/uid")
    String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }

}
