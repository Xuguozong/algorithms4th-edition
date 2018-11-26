package com.work.sort;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static void sort(int[] arr){
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 1; j > i ; j--) {
                if (arr[j] < arr[i]){
                    temp = arr[j];
                    arr[j] = arr [i];
                    arr[i] = temp;
                }
            }
        }
    }
}
