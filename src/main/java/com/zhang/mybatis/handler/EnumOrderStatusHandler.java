package com.zhang.mybatis.handler;

import com.zhang.mybatis.entity.OrderStatusEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName EnumOrderStatusHandler
 * @Author zhangjiwei
 * @Date 2019/9/1 15:17
 * @Description
 */
public class EnumOrderStatusHandler extends BaseTypeHandler<OrderStatusEnum> {
    public EnumOrderStatusHandler(Class<OrderStatusEnum> type) {
        if (type == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        }
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, OrderStatusEnum parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getValue());
    }

    @Override
    public OrderStatusEnum getNullableResult(ResultSet rs, String columnName) throws SQLException {
        int i = rs.getInt(columnName);
        if (rs.wasNull()) {
            return null;
        } else {
            return locateEnum(i);
        }
    }

    @Override
    public OrderStatusEnum getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        int i = rs.getInt(columnIndex);
        if (rs.wasNull()) {
            return null;
        } else {
            // 根据数据库中的值，定位Enum子类
            return locateEnum(i);
        }
    }

    @Override
    public OrderStatusEnum getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        int i = cs.getInt(columnIndex);
        if (cs.wasNull()) {
            return null;
        } else {
            // 根据数据库中的值，定位Enum子类
            return locateEnum(i);
        }
    }

    private OrderStatusEnum locateEnum(int value) {
        for (OrderStatusEnum status : OrderStatusEnum.values()) {
            if (status.getValue() == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("未知的枚举类型：" + value);
    }
}
