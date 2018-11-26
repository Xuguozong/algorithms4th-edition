package com.work.sort;

/**
 * 直接插入排序
 */
public class InsertionSort {

    public static void sort(int[] arr){
        int temp;
        for (int i = 1; i < arr.length; i++) {
            System.out.println("-------第"+i+"轮循环---------");

            temp = arr[i];
            int j;
            for (j = i - 1; j >= 0 && arr[j] > temp;j-- ) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = temp;
            for (int k : arr) {
                System.out.println(k);
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        int sshift = 0;
        int ssize = 1;
        while (ssize < 16) {
            ++sshift;
            ssize <<= 1;
        }

    }
}
