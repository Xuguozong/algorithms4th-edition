package com.work.sort;

/**
 * 选择排序
 */
public class SelectionSort {

    public static void sort(int[] arr){
        int temp;
        // k 作为每趟筛选出的最小值
        int k;
        for (int i = 0; i < arr.length - 1; i++) {
            k = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[k]){
                    k = j;
                }
            }
            temp = arr[k];
            arr[k] = arr[i];
            arr[i] = temp;
        }
    }
}
