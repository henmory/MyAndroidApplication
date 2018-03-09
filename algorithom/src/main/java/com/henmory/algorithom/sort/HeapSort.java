package com.henmory.algorithom.sort;

import java.util.Arrays;

/**
 * author: henmory
 * time:  2/7/18
 * function:
 * description:
 */

public class HeapSort {

    public void heapAdjust(int[] a, int s, int length){

        int temp = 0;
        for (int j = 2 * s; j <= length;  j = j * 2) {
            if (j < length && a[j] < a[j + 1]){
                j++;
            }
            //System.out.println("j = " + j);
            if (a[s] > a[j]){
                break;
            }else{
                temp = a[s];
                a[s] = a[j];
                a[j] = temp;
                s = j;
//                System.out.println(Arrays.toString(a));
            }

        }
    }

    public void swap(int[] a, int index1, int index2){
        int temp = 0;
        temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }

    public void heapSort(int[] a){
        for (int i = (a.length - 1) / 2; i > 0 ; i--){
            heapAdjust(a, i, a.length - 1);
        }
//        System.out.println(Arrays.toString(a));

        for (int i = a.length; i > 1; i--) {
            swap(a, 1, i - 1);
//            System.out.println("调整大堆之前" + Arrays.toString(a));
            heapAdjust(a, 1, i - 2);
//            System.out.println("调整大堆之后" + Arrays.toString(a));
        }

    }
}
