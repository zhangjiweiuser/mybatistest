package com.zhang.mybatis.entity;

/**
 * @ClassName Node
 * @Author zhangjiwei
 * @Date 2019/8/12 20:56
 * @Description
 */
public class Node {
    private String id;
    private String name;
    private Integer type;
    private String parentId;

    public Node(String id, String name, Integer type, String parentId) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.parentId = parentId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}
