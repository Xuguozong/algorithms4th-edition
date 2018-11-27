package com.work.algorithms4thedition.sort;

/**
 * ClassName Example
 * Description 排序模板类
 * Author xuguozong
 * Date 2018/11/22 9:48
 * Version 0.5.0
 */
public class Example {

    protected static final String[] STRS = new String[]{"h", "j", "a", "x", "o", "z", "e", "b"};

    /**
     * 比较大小
     * @param a
     * @param b
     * @return
     */
    protected static boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }

    /**
     * 打印
     * @param a
     */
    protected static void print(Comparable[] a){
        for (Comparable c : a){
            System.out.print(c);
        }
        System.out.println();
    }

    /**
     * 交换位置
     * @param a
     * @param i
     * @param j
     */
    protected static void exchange(Comparable[] a, int i, int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     * 判断是否已排序
     * @param a
     * @return
     */
    protected static boolean isSorted(Comparable[] a){
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])){
                return false;
            }
        }
        return true;
    }
}
