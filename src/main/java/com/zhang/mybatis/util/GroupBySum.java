package com.zhang.mybatis.util;

import com.google.common.collect.Lists;
import com.zhang.mybatis.entity.User;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName GroupBySum
 * @Author zhangjiwei
 * @Date 2019/8/14 16:29
 * @Description
 */
public class GroupBySum {

    public static void main(String[] args) {
        List<User> users = Lists.newArrayList();
        User user = new User();
        user.setId(1);
        user.setAge(10);
        users.add(user);
        user = new User();
        user.setId(1);
        user.setAge(15);
        users.add(user);
        user = new User();
        user.setId(2);
        user.setAge(18);
        users.add(user);
        user = new User();
        user.setId(3);
        user.setAge(10);
        users.add(user);
        for (User user1 : users) {
            System.out.println(user1.toString());
        }
        Map<Integer, List<User>> maps = users.stream().collect(Collectors.groupingBy(User::getId));
        System.out.println(maps);
    }
}
