package com.zhang.mybatis.dao;

import com.zhang.mybatis.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName UserDao
 * @Author zhangjiwei
 * @Date 2019/7/12 14:18
 * @Description
 */
public interface UserDao {
    int insert(@Param("user") User user);

    User findById(int id);

    User findByNameAndPassword(@Param("userName") String userName,@Param("password") String password);

    List<User> findAllUsers();
}
