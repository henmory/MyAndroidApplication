package com.henmory.algorithom.sort;

import java.util.Arrays;

/**
 * author: henmory
 * time:  3/9/18
 * function:
 * description:选择最小的放在第一个元素，选择的手段的是记录最小的变量，
 */

public class SelectSort {

    private int compareCount = 0;
    private int swapCount = 0;
    public void selectSort(int[] nums){

        //记录最小的数据和下标
        int min_index = 0;
        int min = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            min_index = i;
            for (int j = i + 1; j < nums.length; j++) {
                compareCount++;
                if (nums[min_index] > nums[j]){
                    swapCount++;
                    min_index = j;
                }
            }
            if (nums[min_index] != nums[i]){
                min = nums[i];
                nums[i] = nums[min_index];
                nums[min_index] = min;
            }
        }
        System.out.println(Arrays.toString(nums));
        System.out.println("选择排序，进行了 " + compareCount +" 次比较 " + swapCount + " 次交换" );

    }
}
