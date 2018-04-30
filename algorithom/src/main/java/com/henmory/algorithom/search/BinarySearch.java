package com.henmory.algorithom.search;

/**
 * author: henmory
 * time:  3/12/18
 * function:
 * description: 二分法查找要求查找的序列为有序的序列才行
 *              这样的序列存放在数组中，查找速度快，但是增删麻烦
 *              由二分法延伸出插值查找和斐波纳切查找
 */

public class BinarySearch {

    public int binarySearch(int[] a, int key){
        int low = 0;
        int high = a.length - 1;

        int middle;
        while (low <= high){
//            System.out.println("low = " + low + " high = " + high);
            middle = (low + high) / 2;

            if (a[middle] > key){
                high = middle - 1;
            }else if(a[middle] < key){
                low = middle + 1;
            }else{
                return middle;
            }
        }
        return -1;
    }
}
