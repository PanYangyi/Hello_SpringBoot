//package com.pyy.helloWorld;
//
//import com.pyy.helloWorld.dao.one.UserOneMapper;
//import com.pyy.helloWorld.dao.two.UserTwoMapper;
//import com.pyy.helloWorld.domian.UserDruidDataSource;
//import com.pyy.helloWorld.domian.userenum.UserSexEnum;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class MutilDataSourceTest {
//
//    @Autowired
//    private UserOneMapper userOneMapper;
////    @Autowired
////    private UserTwoMapper userTwoMapper;
//
//    @Test
//    public void testInsert() throws Exception {
//        userOneMapper.insert(new UserDruidDataSource("aammxd", "a123456", UserSexEnum.MAN));
//        userOneMapper.insert(new UserDruidDataSource("bbmmxd", "b123456", UserSexEnum.WOMAN));
//        userOneMapper.insert(new UserDruidDataSource("ccmmxd", "b123456", UserSexEnum.WOMAN));
//
////		Assert.assertEquals(3, userMapper.getAll().size());
//    }
//
//    @Test
//    public void testQuery() throws Exception {
//        List<UserDruidDataSource> users = userOneMapper.getAll();
//        if(users==null || users.size()==0){
//            System.out.println("is null");
//        }else{
//            System.out.println(users.size());
//        }
//    }
//
//
//    @Test
//    public void testUpdate() throws Exception {
//        UserDruidDataSource user = userOneMapper.getOne((long) 28);
//        System.out.println(user.toString());
//        user.setNickName("neo");
//        userOneMapper.update(user);
//        Assert.assertTrue(("neo".equals(userOneMapper.getOne((long) 28).getNickName())));
//    }
//}
