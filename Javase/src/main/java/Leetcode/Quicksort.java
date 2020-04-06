package Leetcode;

import java.util.Scanner;

public class Quicksort {

    public static void main(String[] args) {
        System.out.println("QuickSort");
        int[] a = {18, 52, 36, 9, 4, 24, 35, 66, 0};
        int start = 0;//左指针为0
        int end = a.length - 1;//右指针为尾
        sort(a, start, end);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ",");
        }
        //0, 52, 36, 9, 4, 24, 35, 66, 18
        //0, 18, 36, 9, 4, 24, 35, 66, 52
        //0, 4, 36, 9, 18, 24, 35, 66, 52
        //0, 4, 18, 9, 36, 24, 35, 66, 52
        //0, 4, 9, 18, 36, 24, 35, 66, 52

    }

    public static void sort(int[] a, int low, int high) {
        int start = low;
        int end = high;
        int key = a[low];//第一个数为key

        //key=18
        while (end > start) {//右大于左时执行
            //从后往前比较
            //右大于左且数组中右的值大于等于key时执行---也就是找到小于key的位置
            while (end > start && a[end] >= key)  //如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
                end--;
            //右小于等于key
            if (a[end] <= key) {
                //a的start与den交换位置
                int temp = a[end];
                a[end] = a[start];
                a[start] = temp;
            }
            //从前往后比较
            //右大于左且数组中左的值小于等于key时执行---也就是左大于key的位置
            while (end > start && a[start] <= key)//如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
                start++;
            //左大于等于key
            if (a[start] >= key) {
                //a的start与den交换位置

                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }
            //此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
            // //0, 4, 9, 18指针, 36, 24, 35, 66, 52
        }
        //end=start=3  low=0,high=9
        //递归
        if (start > low) sort(a, low, start - 1);//左边序列。第一个索引位置到关键值索引-1
        if (end < high) sort(a, end + 1, high);//右边序列。从关键值索引+1到最后一个

    }
}