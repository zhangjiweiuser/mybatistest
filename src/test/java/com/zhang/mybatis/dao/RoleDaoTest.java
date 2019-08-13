package com.zhang.mybatis.dao;

import com.google.common.collect.Lists;
import com.zhang.mybatis.entity.Role;
import com.zhang.mybatis.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @ClassName UserDaoTest
 * @Author zhangjiwei
 * @Date 2019/7/12 14:23
 * @Description
 */
public class RoleDaoTest {

    private SqlSession getSqlSession() throws IOException {
        String resource = "configuration.xml";
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                .build(Resources.getResourceAsReader(resource));
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        return sqlSession;
    }

    @Test
    public void findAvg() throws IOException {

        RoleDao roleDao = getSqlSession().getMapper(RoleDao.class);
        Map<String,Object> role = roleDao.getAvg();
        System.out.println(role.toString());
    }

}
