package com.work.algorithms4thedition.sort.quick;

import com.work.algorithms4thedition.sort.Example;

/**
 * ClassName BasicQuickSortExample
 * Description 快速排序
 * 1.定基准----首先随机选择一个元素为基准
 * 2.划分区----所有比基准小的元素置于基准左侧，比基准大的置于基准右侧
 * 3.递归调用--递归地调用此切分过程
 * Author xuguozong
 * Date 2018/11/27 11:35
 * Version 0.5.0
 */
public class BasicQuickSortExample extends Example {

    public static void sort(Comparable[] a){
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int lo, int hi){
        if (lo >= hi){
            return;
        }
        int j = partion(a, lo, hi);
        sort(a, lo, j);
        sort(a, j + 1, hi);
    }

    /**
     * before:  ------------------------------
     *         \V\                            \
     *          ------------------------------
     *          ^                            ^
     *          lo                           hi
     *
     * during: ------------------------------
     *         \V\    V    \-------\   V     \
     *         ------------------------------
     *                     ^       ^
     *                     i       j
     *
     *  after:  ------------------------------
     *          \             \V\             \
     *          ------------------------------
     *          ^              ^             ^
     *          lo             j             hi
     * @param a
     * @param lo
     * @param hi
     * @return 基准元素下标
     */
    public static int partion(Comparable[] a, int lo, int hi){
        // partion into a[lo..i-1],a[i],a[i+1..hi]
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        while (true){
            // scan right, scan left, check for scan complete, and exchange
            while (less(a[++i], v)){
                if (i == hi){
                    break;
                }
            }
            while (less(v, a[--j])){
                if (j == lo){
                    break;
                }
            }
            if (i >= j){
                break;
            }
            exchange(a, i, j);
        }
        exchange(a, lo, j);
        return j;
    }

    public static void main(String[] args){
        print(STRS);
        sort(STRS);
        print(STRS);
    }
}
