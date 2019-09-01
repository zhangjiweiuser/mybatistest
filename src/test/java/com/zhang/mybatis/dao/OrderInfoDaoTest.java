package com.zhang.mybatis.dao;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.zhang.mybatis.entity.OrderInfo;
import com.zhang.mybatis.entity.OrderStatusEnum;
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
public class OrderInfoDaoTest {

    private SqlSession getSqlSession() throws IOException {
        String resource = "configuration.xml";
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                .build(Resources.getResourceAsReader(resource));
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        return sqlSession;
    }

    @Test
    public void findById() throws IOException {

        OrderInfoDao orderInfoDao = getSqlSession().getMapper(OrderInfoDao.class);
        OrderInfo orderInfo = orderInfoDao.findById(1);
        Assert.assertNotNull("没有数据", orderInfo);
        System.out.println(JSONObject.toJSONString(orderInfo.toString()));
        System.out.println(orderInfo.getStatus().getDesc());
    }


    @Test
    public void insertCreate() throws IOException {
        OrderInfoDao orderInfoDao = getSqlSession().getMapper(OrderInfoDao.class);
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setStatus(OrderStatusEnum.CREATE);
        int num = orderInfoDao.insert(orderInfo);
        System.out.println(num);

        Assert.assertEquals(1, num);
    }

    @Test
    public void insertPaying() throws IOException {
        OrderInfoDao orderInfoDao = getSqlSession().getMapper(OrderInfoDao.class);
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setStatus(OrderStatusEnum.PAYING);
        int num = orderInfoDao.insert(orderInfo);
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
