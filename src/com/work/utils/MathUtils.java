package com.work.utils;

import java.util.Arrays;

/**
 * ClassName MathUtils
 * Description TODO
 * Author xuguozong
 * Date 2018/11/21 22:07
 * Version 0.5.0
 */
public final class MathUtils {

    private MathUtils(){}

    /**
     * 计算绝对值
     * @param x
     * @return
     */
    public static int abs(int x){
        return x <= 0 ? -x : x;
    }

    /**
     * 判断是否是素数
     * @param n
     * @return
     */
    public static boolean isPrime(int n){
        if (n < 2){
            return false;
        }
        for (int i = 2; i * i <= n; i++){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }

    /**
     * 计算平方根（牛顿迭代法）
     * @param n
     * @return
     */
    public static double sqrt(double n){
        if (n < 0){
            return Double.NaN;
        }
        // 误差控制
        double err = 1e-15;
        double t = n;
        while (Math.abs(t - n/t) > err * t){
            t = (n/t + t) / 2.0;
        }
        return t;
    }

    /**
     * 二分查找
     * @param key
     * @param arr
     * @return
     */
    public static int binaryFind(int key, int[] arr){
        Arrays.sort(arr);
        int lo = 0;
        int hi = arr.length -1;
        while (lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if (key < arr[mid]){
                hi = mid -1;
            }else if(key > arr[mid]){
                lo =mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    /**
     * 递归式二分查找
     * @param key
     * @param arr
     * @param lo
     * @param hi
     * @return
     */
    public static int binarySearchRecrusive(int key, int[] arr, int lo, int hi){
        if (lo > hi){
            return -1;
        }
        int mid = lo + (hi -lo) /2;
        if (arr[mid] > key) {
            return binarySearchRecrusive(key, arr, lo, mid - 1);
        } else if (arr[mid] < key){
            return binarySearchRecrusive(key, arr, mid + 1, hi);
        } else {
            return mid;
        }
    }

    public static void main(String[] args){
        System.out.println(isPrime(5));
        System.out.println(sqrt(8));
        final int[] ints = {23, 55, 3, 78, 11, 45};
        System.out.println(binaryFind(23, ints));
    }
}
