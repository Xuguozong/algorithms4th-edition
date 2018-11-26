package com.work.sort;

public class Test {
    public static void main(String[] args){
        int[] arr = new int[]{3467, -2, 34, 2, 355, 23544, 33, 46, 122, 46, 1, 0, -50};
        //BubbleSort.sort(arr);
        //SelectionSort.sort(arr);
        InsertionSort.sort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
