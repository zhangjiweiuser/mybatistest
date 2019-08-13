package com.zhang.mybatis.dao;

import com.zhang.mybatis.entity.OrgDepartment;

import java.util.List;

/**
 * @ClassName OrgDepartmentDao
 * @Author zhangjiwei
 * @Date 2019/8/12 21:17
 * @Description
 */
public interface OrgDepartmentDao {

    List<OrgDepartment> getAll();
}
