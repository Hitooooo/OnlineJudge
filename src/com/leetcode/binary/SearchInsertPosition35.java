package com.leetcode.binary;

import org.junit.Test;

/**
 * Given a sorted array and a target value, return the index if the target is
 * found. If not, return the index where it would be if it were inserted in
 * order. You may assume no duplicates in the array.
 * 
 * @author hitomeng
 * @date 2020/01/14
 */
public class SearchInsertPosition35{

    public int searchInsert(int[] nums, int target) {
        // 处理异常值
        if(nums == null || nums.length == 0){
            return 0;
        }
        // 需要处理target不在nums中的情况吗？不需要，可以在左右边界中包括
        // 1.确定左右边界
        int left = 0;
        int right = nums.length;
        while(left < right){
            // 2.确定中位数.中位数与Target相关的，根据nums的长度分奇数和偶数情况。
            // 插入位置为大于或等于target的最小值。中位数应该是中间或中间-1
            int mid = left + (right - left + 1) / 2;
            // 3.排除中位数的情况
            if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        // 4.后处理
        return left;    
    }

    @Test
    public void test(){
        int[] arr = {1,3,5,6};
        int r = searchInsert(arr, 2);
        System.out.println(r);
    }
}