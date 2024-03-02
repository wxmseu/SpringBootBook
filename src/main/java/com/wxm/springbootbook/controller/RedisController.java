package com.wxm.springbootbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/redistemplate")
    public String redisTemplate(){
        // 向redis中添加一个key为hello， value为world的记录
        stringRedisTemplate.opsForValue().set("hello", "world");
        return stringRedisTemplate.opsForValue().get("hello");
    }


}
