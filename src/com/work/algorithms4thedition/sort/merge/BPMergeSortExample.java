package com.work.algorithms4thedition.sort.merge;

/**
 * ClassName BPMergeSortExample
 * Description TODO
 * 特点：Bottom-Up 迭代法
 * Author xuguozong
 * Date 2018/11/27 19:48
 * Version 0.5.0
 */
public class BPMergeSortExample extends MergeSort {

    private BPMergeSortExample(){}

    private static Comparable[] aux;

    public static void sort(Comparable[] a){
        final int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz + sz){
            for (int lo = 0; lo < N - sz; lo += sz + sz) {
                merge(a, aux, lo, lo + sz -1, Math.min(lo + sz + sz -1, N - 1));
            }
        }
    }

    public static void main(String[] args){
        print(STRS);
        sort(STRS);
        print(STRS);
    }
}
