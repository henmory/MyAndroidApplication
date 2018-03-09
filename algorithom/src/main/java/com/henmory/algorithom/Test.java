package com.henmory.algorithom;


import com.henmory.algorithom.sort.BubbleSort;
import com.henmory.algorithom.sort.InsertSort;
import com.henmory.algorithom.sort.MergeSort;
import com.henmory.algorithom.sort.SelectSort;

import java.util.Arrays;

/**
 * author: henmory
 * time:  2/7/18
 * function:
 * description:
 */

public class Test {

    public static void main(String[] args){
        int[] a = {-1,4,2,5,7,8,9,3,1,0};
   //     HeapSort heapSort = new HeapSort();
   //     heapSort.heapSort(a);
//        System.out.println(Arrays.toString(a));

//        MergeSort mergeSort = new MergeSort();
//        mergeSort.mergeSort(a,  0,9);
//        System.out.println(Arrays.toString(a));

        testBubbleSort(a);
        testSelectSort(a);
        testInsertSort(a);
        testShellSort(a);
    }

    private static void testShellSort(int[] a) {
        InsertSort insertSort = new InsertSort();
        insertSort.shellSort(a);
    }

    private static void testInsertSort(int[] a) {
        InsertSort insertSort = new InsertSort();
        insertSort.insertSort(a);
    }

    private static void testSelectSort(int[] a) {
        SelectSort selectSort = new SelectSort();
        selectSort.selectSort(a);
    }

    private static void testBubbleSort(int[] a) {
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort1(a);
        bubbleSort.bubbleSort2(a);
        bubbleSort.bubbleSort3(a);
    }


}
