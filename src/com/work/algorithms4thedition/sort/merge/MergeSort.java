package com.work.algorithms4thedition.sort.merge;

import com.work.algorithms4thedition.sort.Example;

/**
 * ClassName MergeSort
 * Description Top-Down 和 Bottom-Up 归并公用的merge()方法
 * Author xuguozong
 * Date 2018/11/27 19:54
 * Version 0.5.0
 */
public abstract class MergeSort extends Example {

    /**
     * 来自算法4
     * stably merge a[lo...mid] with a[mid+1...hi] using aux[lo...hi]  Abstract in-place merge
     * @param a 源数组
     * @param aux 辅助数组
     * @param lo
     * @param mid
     * @param hi
     */
    protected static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi){
        // 前提条件， 子数组已经排好序
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid + 1, hi);

        // 拷贝至aux
        for(int k = lo; k <= hi; k++){
            aux[k] = a[k];
        }

        // 归并回a[]

        // 左序列指针
        int i = lo;
        // 右序列指针
        int j = mid + 1;
        for (int k = lo; k <= hi; k++){
            if (i > mid){
                // 左半边用尽， 取右半边元素
                a[k] = aux[j++];
            } else if (j > hi){
                // 右半边用尽， 取左半边元素
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])){
                // 右半边当前元素小于左半边当前元素， 取右半边元素
                a[k] = aux[j++];
            } else {
                // 右半边当前元素大于等于左半边当前元素， 取左半边元素
                a[k] = aux[i++];
            }
        }
        // postcondition a[lo...hi] is sorted
        assert isSorted(a, lo, hi);
    }

    /**
     * 来自《算法与数据结构.Java语言描述》
     * @param a
     * @param aux
     * @param leftPos left-most index of subarray
     * @param rightPos index of the start of the second half
     * @param rightEnd right-most index of the subarray
     */
    protected static void mergeWithDSAA(Comparable[] a, Comparable[] aux, int leftPos, int rightPos, int rightEnd){
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos  + 1;

        // main loop
        while (leftPos <= leftEnd && rightPos <= rightEnd){
            if (less(a[leftPos], a[rightPos])){
                aux[tmpPos++] = a[leftPos++];
            } else {
                aux[tmpPos++] = a[rightPos++];
            }
        }

        while (leftPos <= leftEnd){
            // copy rest of first half
            aux[tmpPos++] = a[leftPos++];
        }

        while (rightPos <= rightEnd){
            // copy rest of right half
            aux[tmpPos++] = a[rightPos++];
        }

        // copy tmpArray back
        for (int i = 0; i < numElements; i++, rightEnd--) {
            a[rightEnd] = aux[rightEnd];
        }
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi){
        for(int i = lo + 1; lo < hi; i++){
            if (less(a[i], a[i - 1])){
                return false;
            }
        }
        return true;
    }
}
