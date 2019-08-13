package com.zhang.mybatis.entity;

/**
 * @ClassName OrgDepartment
 * @Author zhangjiwei
 * @Date 2019/8/12 21:16
 * @Description
 */
public class OrgDepartment {
    private Integer id ;
    private Integer parentId;
    private String orgName;
    private Integer type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
