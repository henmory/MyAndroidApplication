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

    /**
     *  @author henmory
     *  @date 3/10/18
     *  @description    堆排序利用了每次比较的结果，不会有重复比较
     *                  实现方式由完全二叉树构成
     *                  构建大顶堆从下往上构建
     *                  索引要从1开始，这样利用下标，利用完全二叉树的特点
     *                  1.先构造大顶堆
     *                  2.把堆顶数据放到数组末尾
     *                  3.再把剩下的元素重构大顶堆，依次类推
     *
     *  @param
     *
     *  @return
    */
    public void heapSort(int[] a){


        int length = a.length - 1;//除去数组为0的元素

        //从最后一个双亲节点开始构建
        for (int i = length / 2; i > 0; i --){
            HeapAdjust(a, i, length);
        }

        //把下标为i的元素与堆顶元素对调，然后重新构建大顶堆
        for (int i = length; i > 1; i--) {
            //下标为i的元素每次与下标为1的元素对调
            swap(a, 1, i);

            //重新构建大顶堆，因为除去第一个元素之外，其他的元素已经是大顶堆了，进而把双亲节点锁定在第一个元素即可
            //在这次构建大顶堆的时候，就已经用到了之前构建大顶堆的经验
            HeapAdjust(a, 1, i);
        }

        System.out.println("堆排序的结果" + Arrays.toString(a));
    }

    /**
     *  @author henmory
     *  @date 3/10/18
     *  @description    构建大顶堆
     *
     *
     *  @param  a 构建的数组
     *  @param  length 数组的长度
     *  @param  s 第一个开始的双亲节点
     *
     *  @return
    */
    private void HeapAdjust(int[] a, int s, int length) {

        int temp = a[s];//记录要排序的双亲节点
        int j = 0;//记录较大的孩子节点

        for (j = 2 * s; j <= length; j *= 2) {

            if ((a[j] < a[j + 1]) && (j < length)){
                j++;
            }

            //双亲节点大于所有的孩子节点，表示对于这个节点来说，不需要重新调整
            if (temp > a[j]){
                break;
            }

            //要不然把双亲节点与较大的节点对调，然后双亲节点指向那个较大的孩子节点，继续对这个孩子节点进行调整
            a[s] = a[j];
            a[j] = temp;
            s = j;
        }
    }


    private void swap(int[] a, int i, int j) {
        int temp = 0;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
