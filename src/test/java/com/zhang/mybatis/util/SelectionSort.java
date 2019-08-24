package com.zhang.mybatis.util;

/**
 * @ClassName SelectionSort
 * @Author zhangjiwei
 * @Date 2019/8/20 10:01
 * @Description
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5, 1, 9, 3, 4, 7, 6, 4, 2};
        selectionSort(arr);
        for (int a : arr) {
            System.out.print(a + "  ");
        }
    }

    private static void selectionSort(int[] arr) {
        if (arr.length == 0) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
        }
    }
}
