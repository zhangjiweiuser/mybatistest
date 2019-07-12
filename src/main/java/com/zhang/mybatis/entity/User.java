package com.zhang.mybatis.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName User
 * @Author zhangjiwei
 * @Date 2019/7/12 14:17
 * @Description
 */
@Data
public class User {
    private int id;
    private String name;
    private String password;
    private int age;
    private int status;
}
