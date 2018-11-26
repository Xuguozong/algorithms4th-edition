package com.work.algorithms4thedition.sort.shell;

import com.work.algorithms4thedition.sort.Example;

/**
 * ClassName ShellSortExample
 * Description 希尔排序
 * Author xuguozong
 * Date 2018/11/22 15:28
 * Version 0.5.0
 */
public class ShellSortExample extends Example {

    private ShellSortExample(){}

    public static void sort(Comparable[] a){
        final int N = a.length;
        // 递增序列 h
        int h = 1;
        while (h < N / 3){
            h = 3 * h + 1;
        }
        while (h >= 1){
            // 将数组变为h有序
            for(int i = h; i < N; i++){
                // 将a[i]插入到a[i - h], a[i - 2 * h], a[i - 3 * h]...之中
                for(int j = i; j >= h && less(a[j], a[j - h]); j -= h){
                    exchange(a, j, j - h);
                }
            }
            h = h / 3;
        }

        if (!isSorted(a)){
            throw new RuntimeException("shell sort fail");
        }
    }

    public static void main(String[] args){
        sort(STRS);
        print(STRS);
        System.out.println(isSorted(STRS));
    }
}
