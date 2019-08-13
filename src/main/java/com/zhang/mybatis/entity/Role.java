package com.zhang.mybatis.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @ClassName Role
 * @Author zhangjiwei
 * @Date 2019/7/20 14:24
 * @Description
 */
@Data
public class Role {
    private int id;
    private int age;
    private int num;
    private BigDecimal avgage;
}
