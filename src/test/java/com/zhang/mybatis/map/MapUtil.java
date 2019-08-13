package com.zhang.mybatis.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MapUtil
 * @Author zhangjiwei
 * @Date 2019/7/24 15:36
 * @Description
 */
public class MapUtil {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>(4);
        map.put("name", "name");
        map.put("age", "name");

        String value = map.get("name");
        System.out.println(value);
    }
}
