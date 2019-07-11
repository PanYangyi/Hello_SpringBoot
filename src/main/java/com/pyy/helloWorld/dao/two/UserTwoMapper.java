package com.pyy.helloWorld.dao.two;

import com.pyy.helloWorld.domian.UserDruidDataSource;

import java.util.List;

public interface UserTwoMapper {
     List<UserDruidDataSource> getAll();

     UserDruidDataSource getOne(Long id);

     void insert(UserDruidDataSource user);

     void update(UserDruidDataSource user);

     void delete(Long id);
}
