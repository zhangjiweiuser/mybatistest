package com.zhang.mybatis.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName GuavaUtil
 * @Author zhangjiwei
 * @Date 2019/8/12 21:39
 * @Description
 */
public class GuavaUtil {
    private static Cache<String, JSONArray> cache;

    private static void init() {
        cache = CacheBuilder.newBuilder().maximumSize(300)
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .concurrencyLevel(10)
                .recordStats()
                .build();
    }

    public static JSONArray getValue(String key) {
        if (cache == null) {
            synchronized (GuavaUtil.class) {
                if (cache == null) {
                    init();
                }
            }
        }
        return cache.getIfPresent(key);
    }

    public static void putValue(String key, JSONArray value) {
        if (cache == null) {
            synchronized (GuavaUtil.class) {
                if (cache == null) {
                    init();
                }
            }
        }
        cache.put(key, value);
    }

    public static void main(String[] args) {
        init();

    }
}
