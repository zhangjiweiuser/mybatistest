package com.zhang.mybatis.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @ClassName OrgTree
 * @Author zhangjiwei
 * @Date 2019/8/23 10:47
 * @Description
 */
@Getter
@Setter
@ToString
public class OrgTree {
    private int id;
    private String name;
    private int type;
    private List<OrgTree> children;
}
