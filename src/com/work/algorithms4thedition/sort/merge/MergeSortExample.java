package com.work.algorithms4thedition.sort.merge;

import com.work.algorithms4thedition.sort.Example;

/**
 * ClassName MergeSortExample
 * Description 原地归并排序(自顶向下的归并排序) 递归实现的归并算法是算法设计中分治思想的典型应用
 * 特点：
 * 1. 时间复杂度： NlogN
 * 2. 需要的额外空间与N 成正比
 *
 * 改进空间：
 *      递归会使小规模问题中的方法调用过于频繁， 可以使用插入排序或选择排序
 * Author xuguozong
 * Date 2018/11/22 20:50
 * Version 0.5.0
 */
public class MergeSortExample extends Example {

    private MergeSortExample(){}

    /**
     * stably merge a[lo...mid] with a[mid+1...hi] using aux[lo...hi]  Abstract in-place merge
     * @param a 源数组
     * @param aux 辅助数组
     * @param lo
     * @param mid
     * @param hi
     */
    public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi){
        // 前提条件， 子数组已经排好序
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid + 1, hi);

        // 拷贝至aux
        for(int k = lo; k <= hi; k++){
            aux[k] = a[k];
        }

        // 归并回a[]
        int i = lo;
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
     * mergesort a[lo..hi] using auxiliary array aux[lo..hi]
     * @param a
     * @param aux
     * @param lo
     * @param hi
     */
    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi){
        if (hi <= lo){
            return;
        }
        int mid = lo + (hi - lo)/2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a
     */
    public static void sort(Comparable[] a){
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
        assert isSorted(a);
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi){
        for(int i = lo + 1; lo < hi; i++){
            if (less(a[i], a[i - 1])){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        sort(STRS);
        print(STRS);
    }
}
