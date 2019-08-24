package com.zhang.mybatis.util;

/**
 * @ClassName BubbleSort
 * @Author zhangjiwei
 * @Date 2019/8/20 9:53
 * @Description
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, 1, 9, 3, 4, 7, 6, 4};
        bubbleSort(arr);
        for (int a : arr) {
            System.out.print(a + "  ");
        }
    }

    private static void bubbleSort(int[] arr) {
        if (arr.length == 0) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }
}
