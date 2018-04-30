package com.henmory.algorithom.sort;

/**
 * author: henmory
 * time:  3/10/18
 * function:
 * description:
 */

public class MergeSort {


    /**
     *  @author henmory
     *  @date 3/10/18
     *  @description
     *
     *  @param  arr 归并的数组
     *          low 开始索引
     *          high 结束索引
     *
     *  @return
    */
    public  void mergeSort(int[] arr, int low, int high)
    {
        //使用递归的方式进行归并排序，所需要的空间复杂度是O（N+logN）
        int mid = (low + high)/2;//分两半
        if(low < high)
        {
            //递归地对左右两边进行排序
            mergeSort(arr, low, mid);
            mergeSort(arr, mid+1, high);
            //合并
            merge(arr, low, mid, high);
        }
    }

    /**
     *  @author henmory
     *  @date 3/10/18
     *  @description
     *
     *  @param  arr 以［low， mid］［mid＋1， high］分为两个数组，然后再合并到arr中
     *
     *  @return
    */
    //merge函数实际上是将两个有序数组合并成一个有序数组
    //因为数组有序，合并很简单，只要维护几个指针就可以了
    private  void merge(int[] arr, int low, int mid, int high)
    {
        //temp数组用于暂存合并的结果
        int[] temp = new int[high - low + 1];
        //左半边的指针
        int i = low;
        //右半边的指针
        int j = mid+1;
        //合并后数组的指针
        int k = 0;

        //将记录由小到大地放进temp数组
        for(; i <= mid && j <= high; k++)
        {
            if(arr[i] < arr[j])
                temp[k] = arr[i++];
            else
                temp[k] = arr[j++];
        }

        //接下来两个while循环是为了将剩余的（比另一边多出来的个数）放到temp数组中
        while(i <= mid)
            temp[k++] = arr[i++];

        while(j <= high)
            temp[k++] = arr[j++];

        //将temp数组中的元素写入到待排数组中
        for(int l = 0; l < temp.length; l++)
            arr[low + l] = temp[l];
    }

    /**
     *  @author henmory
     *  @date 3/11/18
     *  @description    归并排序采用迭代的方法，因为递归的算法会浪费很多内存空间，时间上也会很长
     *
     *  @param
     *
     *  @return
    */

    public void mergeSort1(int[] a){
        //数组长度
        int len = a.length;
        //步长
        int k = 1;
        //步长小于数组个数
        while(k < len){
            mergePass(a, k, len);//合并
            k *= 2;//步长增倍
        }

    }

    /**
     *  @author henmory
     *  @date 3/11/18
     *  @description
     *
     *  @param  a   原始数组
     *          k   步长
     *          len 数组长度
     *
     *  @return
    */
    private void mergePass(int[] a, int k, int len) {
        int i = 0;
        int j = 0;

        //当这次合并的所有数组没有超越数组界
        while(i + 2 * k - 1 <= len ){

            //合并[i,  i＋ k - 1] [i + k, i + 2 * k - 1]
            merge(a, i, i + k - 1, i + 2 * k - 1);
            //合并下一个
            i = i + 2 * k;
        }

        //这段代码保证了，将那些“落单的”长度不足两两merge的部分和前面merge起来。？？？？
        if (i + k < a.length){
            merge(a, i,i + k -1, a.length - 1);
        }

    }


}
