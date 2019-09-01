package com.zhang.mybatis.entity;

import lombok.Data;

/**
 * @ClassName OrderInfo
 * @Author zhangjiwei
 * @Date 2019/9/1 15:16
 * @Description
 */
@Data
public class OrderInfo {

    private int id;
    private OrderStatusEnum status;
}
