package com.zhang.mybatis.entity;

import lombok.Getter;
import lombok.ToString;

/**
 * @ClassName OrderStatusEnum
 * @Author zhangjiwei
 * @Date 2019/9/1 15:12
 * @Description
 */
@Getter
@ToString
public enum OrderStatusEnum {
    /**
     * 创建
     */
    CREATE(0, "创建"),
    PAYING(1, "支付中"),
    IN_PROGRESS(2, "支付成功"),
    FAILED(3, "支付失败"),
    REVERSED(4, "取消订单");
    /**
     * 状态码
     */
    private int value;
    /**
     * 描述
     */
    private String desc;

    OrderStatusEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
