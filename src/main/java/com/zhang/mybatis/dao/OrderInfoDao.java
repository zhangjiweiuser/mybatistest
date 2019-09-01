package com.zhang.mybatis.dao;

import com.zhang.mybatis.entity.OrderInfo;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName UserDao
 * @Author zhangjiwei
 * @Date 2019/7/12 14:18
 * @Description
 */
public interface OrderInfoDao {
    int insert(@Param("orderInfo") OrderInfo orderInfo);

    OrderInfo findById(@Param("id") int id);
}
