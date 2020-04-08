package com.leetcode;

import com.leetcode.dp.NumArray303;
import com.leetcode.top100.medium.LRUByDoubleList;

/**
 * @author Mht
 */
public class Main {

    public static void main(String[] args) {
        NumArray303 n =  new NumArray303(new int[]{1,2,3,4,5});        
        int res = n.sumRange(1, 2);
        System.out.println(res);
    }


    public static int partition(int arr[], int begin, int end) {
        int pov = begin;
        int povValue = arr[pov];

        int l = begin;
        int r = end;
        while(l < r){
            while(arr[r] >= povValue && l < r){
                r--;
            }
            while(arr[l] <= povValue && l < r){
                l++;
            }
            swap(arr, l, r);
        }
        // 将被看作pov的首个元素放到该返回的位置，也就是跳出循环时l=r的位置，必须保证l=r是小于等于povValue的
        // 所以whlie循环里面的第一个必须是从右侧开始，保证r指向的一定是小于povValue的。
        swap(arr, begin, r);
        return r;
    }

    public static void swap(int[] arr ,int l ,int r){
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

}
