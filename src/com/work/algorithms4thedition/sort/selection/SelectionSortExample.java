package com.work.algorithms4thedition.sort.selection;

import com.work.algorithms4thedition.sort.Example;

/**
 * ClassName SelectionSortExample
 * Description 选择排序
 *  对于长度为N的数组，需要比较N^2/2次，移动N次
 *  特点：
 *  1. 运行时间和输入的数组是否排序无关
 *  2. 数据移动是最少的（交换N次）
 * Author xuguozong
 * Date 2018/11/22 9:58
 * Version 0.5.0
 */
public class SelectionSortExample extends Example {

    private SelectionSortExample(){}

    public static void sort(Comparable[] a) {
        final int N = a.length;
        for (int i = 0; i < N; i++) {
            // 每次外部循环最小元素的索引
            int min = i;
            for (int j = i + 1; j < N; j++) {
                // 内部循环比较当前元素和已知的最小元素
                if (less(a[j], a[min])){
                    min = j;
                }
            }
            // 交换元素，总是执行N次
            exchange(a, i, min);
        }
        if (!isSorted(a)){
            throw new RuntimeException("selection sort fail");
        }
    }

    public static void main(String[] args){
        sort(STRS);
        print(STRS);
        System.out.println(isSorted(STRS));
    }
}
