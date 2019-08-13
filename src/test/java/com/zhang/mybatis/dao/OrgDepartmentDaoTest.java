package com.zhang.mybatis.dao;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.collect.Lists;
import com.zhang.mybatis.entity.OrgDepartment;
import com.zhang.mybatis.entity.User;
import com.zhang.mybatis.util.GuavaUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName UserDaoTest
 * @Author zhangjiwei
 * @Date 2019/7/12 14:23
 * @Description
 */
public class OrgDepartmentDaoTest {

    private SqlSession getSqlSession() throws IOException {
        String resource = "configuration.xml";
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                .build(Resources.getResourceAsReader(resource));
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        return sqlSession;
    }

    @Test
    public void findAll() throws IOException {
        OrgDepartmentDao orgDepartmentDao = getSqlSession().getMapper(OrgDepartmentDao.class);
        List<OrgDepartment> list = orgDepartmentDao.getAll();
//        System.out.println(JSONObject.toJSONString(list, SerializerFeature.PrettyFormat));
        JSONArray result = GuavaUtil.getValue("tree");
        if (null != result) {
            System.out.println("aa:"+JSONObject.toJSONString(result));
        }else{
            System.out.println("为空");
        }
        result = getTree(0, list);
        GuavaUtil.putValue("tree", result);
        result = GuavaUtil.getValue("tree");
        if (null != result) {
            System.out.println("aa:"+JSONObject.toJSONString(result));
        }
        result = GuavaUtil.getValue("tree");
        if (null != result) {
            System.out.println("aa:"+JSONObject.toJSONString(result));
        }
    }

    private static JSONArray getTree(int id, List<OrgDepartment> list) {
        List<OrgDepartment> childs = getChilds(id, list);
        JSONArray tree = new JSONArray();
        for (OrgDepartment child : childs) {
            JSONObject result = new JSONObject();
            result.put("id", id);
            result.put("name", child.getOrgName());
            result.put("type", child.getType());
            JSONArray childTree = getTree(child.getId(), list);
            if (!childTree.isEmpty()) {
                result.put("child", childTree);
            }
            tree.fluentAdd(result);
        }
        return tree;
    }

    private static List<OrgDepartment> getChilds(int id, List<OrgDepartment> list) {
        return list.stream().filter(o -> o.getParentId() == id).collect(Collectors.toList());
    }
}
