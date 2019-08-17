package com.zhang.mybatis.util;

import java.util.Calendar;

/**
 * @ClassName CaseTest
 * @Author zhangjiwei
 * @Date 2019/8/17 10:05
 * @Description
 */
public class CaseTest {
    public static void main(String[] args) {
        System.out.println(getStr(1));
        System.out.println(getStr(2));
        System.out.println(getStr(4));
        System.out.println(getStr(7));
        Calendar end = Calendar.getInstance();
        end.set();
    }

    private static String getStr(int num) {
        switch (num) {
            case 1:
                return "1";
            case 2:
                return "2";
            default:
                return "0";
            case 3:
                return "3";
            case 4:
                return "4";
        }
    }
}
