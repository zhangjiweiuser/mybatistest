package com.zhang.mybatis.interceptor;

import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.*;

import java.sql.Connection;
import java.util.Properties;

/**
 * @ClassName ExamplePlugin
 * @Author zhangjiwei
 * @Date 2019/7/15 14:01
 * @Description
 */
@Intercepts({
        @Signature(
                type = StatementHandler.class,
                method = "prepare",
                args = {Connection.class, Integer.class}
        )
})
public class ExamplePlugin implements Interceptor {
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("interceptor.." + invocation.getMethod());

        Object target = invocation.getTarget();
        System.out.println("当前拦截到的对象：" + target);
        if(target instanceof RoutingStatementHandler){
            RoutingStatementHandler handler = (RoutingStatementHandler) target;
            BoundSql boundSql = handler.getBoundSql();
            System.out.println(boundSql.getSql());
            System.out.println(boundSql.getParameterMappings());
            System.out.println(boundSql.getParameterObject());
        }
        return invocation.proceed();
    }

    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    public void setProperties(Properties properties) {

    }
}
