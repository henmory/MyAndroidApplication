package com.henmory.algorithom;


import com.henmory.algorithom.search.BinarySearch;
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
//        int[] a = {6,4,2,5,7,8,9,3,1,0};
//        testBubbleSort(a);
//        testSelectSort(a);
//        tepivotstInsertSort(a);
//        testShellSort(a);
//        testHeapSort(a);
//        testMergeSort(a);
//        testQuickSort(a);
        int[] a = {0,1,2,3,4,5,6,7,8,9};
        int index = testBinarySearch(a, 7);
        System.out.println(index);
    }

    private static int testBinarySearch(int[] a, int i) {
        BinarySearch binarySearch = new BinarySearch();
        return  binarySearch.binarySearch(a, i);
    }

    private static void testMergeSort(int[] a) {
        MergeSort mergeSort = new MergeSort();
//        mergeSort.mergeSort(a,0, a.length - 1);
        mergeSort.mergeSort1(a);
        System.out.println(Arrays.toString(a));
    }

    private static void testHeapSort(int[] a) {
        SelectSort selectSort = new SelectSort();
        selectSort.heapSort(a);
    }

    /**
     *  @author henmory
     *  @date 3/9/18
     *  @description
     *
     *  @param
     *
     *  @return
    */
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
//        bubbleSort.bubbleSort1(a);
//        bubbleSort.bubbleSort2(a);
        bubbleSort.bubbleSort3(a);
    }

    private static void testQuickSort(int[] a){
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.quickSort(a);
        System.out.println(Arrays.toString(a));
    }


}
