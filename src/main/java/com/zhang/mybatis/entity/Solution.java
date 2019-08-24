package com.zhang.mybatis.entity;

/**
 * @ClassName Solution
 * @Author zhangjiwei
 * @Date 2019/8/22 9:38
 * @Description
 */
public class Solution {
    public static void main(String[] args) {
//        System.out.println(romanToInt("IV"));
//        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("MCMXCIV"));
    }

    private static int getValue(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                throw new IllegalArgumentException("Illegal character");
        }
    }

    public static int romanToInt(String s) {
        int result = 0, i = 0, n = s.length();
        while (i < n) {
            char c = s.charAt(i);
            System.out.println(c);
            int current = getValue(s.charAt(i));
            if (i == n - 1 || current >= getValue(s.charAt(i + 1))) {
                result += current;
            } else {
                result -= current;
            }
            i++;
        }
        return result;
    }
}
