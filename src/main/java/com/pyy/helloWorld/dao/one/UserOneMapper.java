package com.pyy.helloWorld.dao.one;

import com.pyy.helloWorld.domian.UserDruidDataSource;

import java.util.List;

public interface UserOneMapper {

     List<UserDruidDataSource> getAll();

     UserDruidDataSource getOne(Long id);

     void insert(UserDruidDataSource user);

     void update(UserDruidDataSource user);

     void delete(Long id);
}
