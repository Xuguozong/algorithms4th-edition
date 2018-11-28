package com.work.algorithms4thedition.sort;

import com.work.algorithms4thedition.sort.insertion.InsertionSortExample;
import com.work.algorithms4thedition.sort.merge.TDMergeSortExample;
import com.work.algorithms4thedition.sort.quick.BasicQuickSortExample;
import com.work.algorithms4thedition.sort.selection.SelectionSortExample;
import com.work.algorithms4thedition.sort.shell.ShellSortExample;

import java.util.Arrays;

/**
 * ClassName SortCompare
 * Description 排序性能比较
 * Author xuguozong
 * Date 2018/11/22 14:34
 * Version 0.5.0
 */
public class SortCompare {

    public static double time(String algo, Double[] a){
        long start = System.currentTimeMillis();
        switch (algo){
            case "insertion" :
                InsertionSortExample.sort(a);
                break;
            case "selection" :
                SelectionSortExample.sort(a);
                break;
            case "shell" :
                ShellSortExample.sort(a);
                break;
            case "merge" :
                TDMergeSortExample.sort(a);
                break;
            case "quick" :
                BasicQuickSortExample.sort(a);
                break;
            case "array.sort" :
                Arrays.sort(a);
                break;
            default:
                throw new RuntimeException("不支持的排序类型");
        }
        return System.currentTimeMillis() - start;
    }

    /**
     *
     * @param algo 排序算法
     * @param scale 排序规模
     * @param times 排序试验次数
     * @return
     */
    public static double randomInput(String algo, int scale, int times){
        double total = 0.0d;
        Double[] a = new Double[scale];
        for(int t = 0; t< times;t++){
            for(int i = 0; i < scale; i++){
                a[i] = Math.random();
            }
            total += time(algo, a);
        }
        return total;
    }

    public static void main(String[] args){
        // TODO 使用Fork/Join
        System.out.println("insertion sort avg:" + randomInput("insertion", 10000, 100)/100);
        System.out.println("selection sort avg:" + randomInput("selection", 10000, 100)/100);
        System.out.println("shell sort avg:" + randomInput("shell", 10000, 100)/100);
        System.out.println("merge sort avg:" + randomInput("merge", 10000, 100)/100);
        System.out.println("quick sort avg:" + randomInput("quick", 10000, 100)/100);
        System.out.println("arrays sort avg:" + randomInput("array.sort", 10000, 100)/100);
    }
}
