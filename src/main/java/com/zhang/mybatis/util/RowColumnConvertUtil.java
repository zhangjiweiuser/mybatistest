package com.zhang.mybatis.util;

/**
 * @ClassName RowColumnConvertUtil
 * @Author zhangjiwei
 * @Date 2019/8/14 11:45
 * @Description
 */
public class RowColumnConvertUtil {
    public static void main(String[] args) {
        int[][] arr1 = new int[4][5];
        int[][] arr2 = new int[5][4];
        int temp = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                temp++;
                arr1[i][j] = temp;
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(arr1[i][j] + "\t\t");
            }
            System.out.println();
        }
        System.out.println("开始交换==============");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                arr2[j][i] = arr1[i][j];
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(arr2[i][j] + "\t\t");
            }
            System.out.println();
        }
    }
}
