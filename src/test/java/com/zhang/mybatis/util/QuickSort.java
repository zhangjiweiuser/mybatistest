package com.zhang.mybatis.util;

/**
 * @ClassName QuickSort
 * @Author zhangjiwei
 * @Date 2019/8/21 9:10
 * @Description
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {23, 46, 0, 11, 11, 8, 18};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("排序后:");
        for (int i : arr) {
            System.out.print(i + "  ");
        }
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int index = getIndex(arr, low, high);
            quickSort(arr, low, index - 1);
            quickSort(arr, index + 1, high);
        }
    }

    private static int getIndex(int[] arr, int low, int high) {
        int tmp = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= tmp) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= tmp) {
                low++;
            }
            arr[high] = arr[low];
        }
        for (int i : arr) {
            System.out.print(i + "  ");
        }
        System.out.println();
        arr[low] = tmp;
        System.out.println("赋值后:");
        for (int i : arr) {
            System.out.print(i + "  ");
        }
        System.out.println();
        return low;
    }
}
