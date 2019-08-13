package com.zhang.mybatis.dao;

import com.google.common.collect.Lists;
import com.zhang.mybatis.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @ClassName UserDaoTest
 * @Author zhangjiwei
 * @Date 2019/7/12 14:23
 * @Description
 */
public class UserDaoTest {

    private SqlSession getSqlSession() throws IOException {
        String resource = "configuration.xml";
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                .build(Resources.getResourceAsReader(resource));
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        return sqlSession;
    }

    @Test
    public void findById() throws IOException {

        UserDao userDao = getSqlSession().getMapper(UserDao.class);
        User user = userDao.findById(4);
        Assert.assertNotNull("没有数据", user);
        System.out.println(user.toString());
    }

    @Test
    public void findByNameAndPassword() throws IOException {
        SqlSession sqlSession = getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.findByNameAndPassword("zhangsan", "zhangsan2");
        Assert.assertNotNull("没有数据", user);
        System.out.println(user.toString());
    }

    @Test
    public void insert() throws IOException {
        UserDao userDao = getSqlSession().getMapper(UserDao.class);
        User user = new User();
        user.setName("zhangsan");
        user.setPassword("zhangsan");
        user.setAge(23);
        user.setStatus(0);
        int num = userDao.insert(user);
        System.out.println(num);

        Assert.assertEquals(1, num);
    }

    @Test
    public void findAllUsers() throws IOException {

        UserDao userDao = getSqlSession().getMapper(UserDao.class);
        List<User> users = userDao.findAllUsers();
        Assert.assertNotNull("用户数据不能为空", users);
        for (User user : users) {
            System.out.println(user.toString());
        }
    }

    @Test
    public void findByIds() throws IOException {
        UserDao userDao = getSqlSession().getMapper(UserDao.class);
        List<User> userLists = userDao.findByIds(Lists.newArrayList(4, 5));
        for (User user : userLists) {
            System.out.println(user.toString());
        }
    }
}
