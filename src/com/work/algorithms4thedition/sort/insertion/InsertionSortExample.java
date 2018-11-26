package com.work.algorithms4thedition.sort.insertion;

import com.work.algorithms4thedition.sort.Example;

/**
 * ClassName InsertionSortExample
 * Description 插入排序
 * 时间和空间复杂度： 对于随机排列的长度为 N 且主键不重复的数组，平均情况下插入排序需要～ N 2 /4 次比
 * 较以及～ N 2 /4 次交换。最坏情况下需要～ N 2 /2 次比较和～ N 2 /2 次交换，最好情况下需要 N-1
 * 次比较和 0 次交换。
 *
 * 特点： 插入排序对于部分有序的数组十分高效，也很适合小规模数组。
 *
 * 改进： 在内循环中将较大的元素都向右移动而不总是交换两个元素（这样访问数组的次数就能减半）。
 * Author xuguozong
 * Date 2018/11/22 11:31
 * Version 0.5.0
 */
public class InsertionSortExample extends Example {

    private InsertionSortExample(){}

    public static void sort(Comparable[] a){
        final int N = a.length;
        for (int i = 1; i < N; i++) {
            // 将a[i]插入到 a[i-1],a[i-2],a[i-3]....之中
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exchange(a, j, j - 1);
            }
        }
        if (!isSorted(a)){
            throw new RuntimeException("insertion sort fail");
        }
    }

    public static void main(String[] args){
        sort(STRS);
        print(STRS);
        System.out.println(isSorted(STRS));
    }
}
