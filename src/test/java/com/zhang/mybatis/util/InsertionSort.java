package com.zhang.mybatis.util;

/**
 * @ClassName InsertionSort
 * @Author zhangjiwei
 * @Date 2019/8/20 10:28
 * @Description
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {5, 1, 9, 3, 4, 7, 6, 4, 2};
        insertSort(arr);
        for (int a : arr) {
            System.out.print(a + "  ");
        }
    }

    private static void insertSort(int[] arr) {
        if (arr.length == 0) {
            return;
        }
        int current;
        for (int i = 0; i < arr.length - 1; i++) {
            current = arr[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < arr[preIndex]) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }
    }
}
