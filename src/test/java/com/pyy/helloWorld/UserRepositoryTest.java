//package com.pyy.helloWorld;
//
//import com.pyy.helloWorld.dao.UserRepository;
//import com.pyy.helloWorld.domian.User;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.annotation.Resource;
//import java.text.DateFormat;
//import java.util.Date;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class UserRepositoryTest {
//
//    @Resource
//    private UserRepository userRepository;
//
//    @Test
//    public void testSave(){
//        Date date = new Date();
//        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
//        String formattedDate = dateFormat.format(date);
///*
//
//        userRepository.save(new User("aa", "aa123456","aa@126.com", "aa",  formattedDate));
//        userRepository.save(new User("bb", "bb123456","bb@126.com", "bb",  formattedDate));
//        userRepository.save(new User("cc", "cc123456","cc@126.com", "cc",  formattedDate));
//*/
//
//        Assert.assertEquals(9,userRepository.findAll().size());
//        Assert.assertEquals("bb",userRepository.findByUserNameOrEmail("bb","cc@126.com").getNickName());
//
//    }
//
//}
