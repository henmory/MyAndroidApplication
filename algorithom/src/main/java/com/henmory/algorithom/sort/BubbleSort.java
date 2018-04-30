package com.henmory.algorithom.sort;

import java.util.Arrays;


/**
 * author: henmory
 * time:  3/9/18
 * function:
 * description:选择最小的放在第一个元素，手段是从后往前两两比较
 */

public class BubbleSort {

    private int compareCount = 0;
    private int swapCount = 0;


    /**
     *  @author henmory
     *  @date 3/9/18
     *  @description 不是标准的冒泡排序，冒泡排序要求相邻的两个两两比较
     *
     *  @param
     *
     *  @return
     */
    public void bubbleSort1(int[] nums){
        int temp = 0;
        compareCount = 0;
        swapCount = 0;
        //循环一次就把最小的放到相应i的位置
        for (int i = 0; i < nums.length - 1; i++) {
            //与它后面的每一个数字对比，满足交换条件就交换
            for (int j = i + 1; j < nums.length;j++){
                compareCount++;
                if (nums[i] > nums[j]){
                    swapCount++;
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
        System.out.println("盗版的冒泡排序，进行了 " + compareCount +" 次比较 " + swapCount + " 次交换" );
    }

    /**
     *  @author henmory
     *  @date 3/9/18
     *  @description 标准的冒泡排序，要求两两相邻的元素进行比较
     *
     *  @param
     *
     *  @return
    */

    public void bubbleSort2(int[] nums){
        int temp = 0;
        compareCount = 0;
        swapCount = 0;

        //每走一趟就选出一个最小的
        for (int i = 0; i < nums.length - 1 ; i++){
            //两两比较，把最小的数据放到第一位
            for (int j = nums.length - 1; j > i; j--){
                compareCount++;
                if (nums[j - 1] > nums[j]){
                    swapCount++;
                    temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
        System.out.println("真正的冒泡排序，进行了 " + compareCount +" 次比较 " + swapCount + " 次交换" );
    }

    /**
     *  @author henmory
     *  @date 3/9/18
     *  @description 优化后的冒泡排序
     *
     *  @param
     *
     *  @return
    */
    public void bubbleSort3(int[] nums){
        int temp = 0;
        compareCount = 0;
        swapCount = 0;

        int flag = 1;
        //每走一趟就选出一个最小的
        for (int i = 0; i < nums.length - 1 && (flag == 1 ); i++){
            //两两比较，把最小的数据放到第一位
            for (int j = nums.length - 1; j > i; j--){
                compareCount++;
                flag = 0;
                if (nums[j - 1] > nums[j]){
                    flag = 1;
                    swapCount++;
                    temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
        System.out.println("真正的冒泡排序而且进行了优化，进行了 " + compareCount +" 次比较 " + swapCount + " 次交换" );
    }

    //核心是把pivot与找到的值一直交换,最后返回它的下标
    private int partition(int[] a, int low, int high){

        int pivot = a[0];
        while (low < high){
            //从末尾找到小于pivot的值
            while (low < high && a[high] >= pivot){
                high--;
            }
            //交换high与low的值
            swap(a, low, high);
            //从头找到大于pivot的值
            while (low < high && a[low] < pivot){
                low++;
            }
            swap(a, low, high);
        }
        return low;
    }

    private void qSort(int[] a, int low, int high){

        int pivot = 0;

        if (low < high){

            pivot = partition(a, low, high);

            qSort(a, low, pivot - 1);
            qSort(a, pivot + 1, high);

        }
    }

    public void quickSort(int[] a){

        qSort(a, 0, a.length - 1);

    }


    private void swap(int[] a, int i, int j) {
        int temp = 0;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
