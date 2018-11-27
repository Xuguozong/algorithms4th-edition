package com.work.algorithms4thedition.sort.merge;

/**
 * ClassName TDMergeSortExample
 * Description 原地归并排序(自顶向下的归并排序) 递归实现的归并算法是算法设计中分治思想的典型应用
 * 特点：Top-Down 递归法
 * 1. 时间复杂度： NlogN
 * 2. 需要的额外空间与N 成正比
 *
 * 改进空间：
 *      递归会使小规模问题中的方法调用过于频繁， 可以使用插入排序或选择排序
 * Author xuguozong
 * Date 2018/11/22 20:50
 * Version 0.5.0
 */
public class TDMergeSortExample extends MergeSort {

    private TDMergeSortExample(){}

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
        // 左边归并排序，使得左子序列有序
        sort(a, aux, lo, mid);
        // 右边归并排序，使得右子序列有序
        sort(a, aux, mid + 1, hi);
        // 归并
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

    public static void main(String[] args){
        print(STRS);
        sort(STRS);
        print(STRS);
    }
}
