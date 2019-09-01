package com.zhang.mybatis.util;

import com.google.common.collect.Lists;
import com.zhang.mybatis.entity.Statistic;

import java.util.List;

/**
 * @ClassName StatisticTest
 * @Author zhangjiwei
 * @Date 2019/8/24 17:52
 * @Description
 */
public class StatisticTest {

    public static void main(String[] args) {
        System.out.println(verifyDataNotNull(createData()));
    }

    private static List<Statistic> createData() {
        List<Statistic> list = Lists.newArrayList();
        list.add(new Statistic(0, 0, 10));
        list.add(new Statistic(0, 0, 10));
        list.add(new Statistic(0, 0, 10));
        list.add(new Statistic(0, 0, 10));
        list.add(new Statistic(0, 0, 10));
        list.add(new Statistic(1, 0, 10));
        return list;
    }

    private static boolean verifyDataNotNull(List<Statistic> data) {
        boolean flag = false;
        for (Statistic s : data) {
            Integer id = s.getId();
            if (id != null && id > 0) {
                flag = true;
                break;
            }
        }
        if (flag) {
            flag = false;
            for (Statistic s : data) {
                Integer id = s.getAge();
                if (id != null && id > 0) {
                    flag = true;
                    break;
                }
            }
        }

        return flag;
    }
}
