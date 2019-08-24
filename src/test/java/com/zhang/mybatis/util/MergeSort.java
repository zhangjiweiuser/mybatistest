package com.zhang.mybatis.util;

/**
 * @ClassName MergeSort
 * @Author zhangjiwei
 * @Date 2019/8/20 17:38
 * @Description
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5, 1, 9, 3, 4, 7, 6, 4, 2};
        mergeSort(arr);
        for (int a : arr) {
            System.out.print(a + "  ");
        }
    }

    public static void mergeSort(int[] arr) {

        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = (L + R) / 2;
        sort(arr, L, mid);
        sort(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int L, int mid, int R) {
        int[] temp = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= R) {
            temp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            temp[i++] = arr[p1++];
        }
        while (p2 <= R) {
            temp[i++] = arr[p2++];
        }
        for (i = 0; i < temp.length; i++) {
            arr[L + i] = temp[i];
        }
    }
}
