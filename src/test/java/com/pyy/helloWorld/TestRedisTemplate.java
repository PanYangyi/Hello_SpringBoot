package com.pyy.helloWorld;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedisTemplate {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testString(){
//        redisTemplate.opsForValue().set("key_three","hello3");
        System.out.println("value = "+redisTemplate.opsForValue().get("key_four"));
//        Assert.assertEquals("hello",redisTemplate.opsForValue().get("ccc"));
    }
}
