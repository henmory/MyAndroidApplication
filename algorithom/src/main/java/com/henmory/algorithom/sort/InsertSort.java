package com.henmory.algorithom.sort;

import java.util.Arrays;
import java.util.Iterator;

/**
 * author: henmory
 * time:  3/9/18
 * function:
 * description: 从第二个元素开始排，如果它小于前面的元素，那么先把这个元素存在临时变量中，
 *              遍历它前面的元素，如果它小于前面的元素，那么让那个元素后移一位，知道它大于某个元素，然后把它自己插到后面的一个位置结束
 */

public class InsertSort {

    public void insertSort(int[] a){

        int temp = 0;
        for (int i = 1; i < a.length; i++){
            if (a[i] < a[i - 1]){
                temp = a[i];
                for (int j = i - 1; j > 0; j--){
                    if (a[j] > temp){
                        a[j + 1] = a[j];
                    }else{
                        a[j + 1] = temp;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(a));

    }


    /**
     *  @author henmory
     *  @date 3/9/18
     *  @description 在直接插入的基础上，修改比较数的间隔，没间隔gap取一个数这样分成了一些组，在这些组内部进行出入排序，之后
     *                  不断缩小gap的距离，这样分组就会越少，每个分组的数量就会越来越多，知道gap为1，排序完毕
     *
     *  @param
     *
     *  @return
    */
   public void shellSort(int[] a){
       int temp = 0;
       int gap = a.length;

       do{
           gap = gap / 3 + 1;

           for (int i = gap; i < a.length; i += gap){
               if (a[i] < a[i - gap]){
                   temp = a[i];
                   for (int j = i - gap; j > 0; j -= gap){
                       if (a[j] > temp){
                           a[j + gap] = a[j];
                       }else{
                           a[j + gap] = temp;
                       }
                   }
               }
           }

       }while (gap > 1);

       System.out.println(Arrays.toString(a));

   }
}
