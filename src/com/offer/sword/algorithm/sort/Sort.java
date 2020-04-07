package com.offer.sword.algorithm.sort;

import java.util.Arrays;

import org.junit.Test;

/**
 * 各类排序实现
 * 
 * @author hitomeng
 * @date 2020-03-22
 */
public class Sort {

    public static int[] insertSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            int current = arr[i + 1];
            int sortedTail = i;
            while (sortedTail >= 0 && current < arr[sortedTail]) {
                arr[sortedTail + 1] = arr[sortedTail];
                sortedTail--;
            }
            arr[sortedTail + 1] = current;
        }
        return arr;
    }

    public static int[] shellSort(int[] array) {
        int len = array.length;
        int temp, gap = len / 2;
        while (gap > 0) {
            // 步长控制下的插入排序
            for (int i = gap; i < len; i++) {
                temp = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > temp) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }
        return array;
    }

    public static int[] bubbleSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length - i - 1;j++){
                if(arr[j + 1] < arr[j]){
                    int temp = arr[j + 1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static int[] selectSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    @Test
    public void test() {
        int[] arr = new int[]{2,3,4,100,99,200,5};
        System.out.println(Arrays.toString(insertSort(arr)));
        System.out.println(Arrays.toString(shellSort(arr)));
        System.out.println(Arrays.toString(bubbleSort(arr)));
        System.out.println(Arrays.toString(selectSort(arr)));
    }

}