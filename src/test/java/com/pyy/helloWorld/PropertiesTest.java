package com.pyy.helloWorld;

import com.pyy.helloWorld.domian.PyyProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertiesTest {

    @Resource
    private PyyProperties pyyProperties;

    @Test
    public void getPro(){
        System.out.println("title:"+pyyProperties.getTitle());
        System.out.println("description:"+pyyProperties.getDescription());
    }

}
