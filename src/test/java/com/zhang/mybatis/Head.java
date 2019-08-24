package com.zhang.mybatis;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Map;

/**
 * @ClassName Head
 * @Author zhangjiwei
 * @Date 2019/8/19 16:56
 * @Description
 */
public class Head {
    public static void main(String[] args) {
        List<List<Map<String, Object>>> head = Lists.newArrayList();
        head.add(Lists.newArrayList(ImmutableMap.of("value", "项目"), ImmutableMap.of("value", "安讯"), ImmutableMap.of("value", "安讯对内")));

        List<List<Map<String, Object>>> body = Lists.newArrayList();
        body.add(Lists.newArrayList(ImmutableMap.of("value", "销售额"), ImmutableMap.of("value", "500"), ImmutableMap.of("value", "1500")));
        body.add(Lists.newArrayList(ImmutableMap.of("value", "利润"), ImmutableMap.of("value", "2500"), ImmutableMap.of("value", "3500")));

        JSONObject result = new JSONObject();
        result.put("head", head);
        result.put("body", body);
        System.out.println(JSONObject.toJSONString(result, SerializerFeature.PrettyFormat));
    }
}
