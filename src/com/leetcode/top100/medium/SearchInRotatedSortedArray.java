package com.leetcode.top100.medium;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand. (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]). You
 * are given a target value to search. If found in the array return its index,
 * otherwise return -1. You may assume no duplicate exists in the array. Your
 * algorithm's runtime complexity must be in the order of O(log n).
 * 有序数组，经过一次随机选取旋转点旋转后，进行查找操作，复杂度必须 <= O(log n)
 * 
 * @author hitomeng
 * @date 2019/09/05
 */
public class SearchInRotatedSortedArray {

    /**
     * 1. 找到最小值： 
     *  a.从中间切一刀，low mid high.肯定一半有序，一半是无序，最小值在无序那段 
     *  b.对无序段再次进行相同操作.哪一半是无序呢？
     *      假设在low->mid段，那么nums[mid]<nums[hi];如果在mid->hi段,nums[mid]>nums[hi].lo >= hi结束循环
     * 2. 根据target与最小值的比较，缩小搜索范围
     * 
     * @param nums   which has been rotated by a random point
     * @param target the num to find
     * @return the index of target ，-1 if not found
     */
    public int search(int[] nums, int target) {
        // 边界值
        if(nums== null || nums.length == 0){
            return -1;
        }

        // 1.确定最小值
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if(nums[mid] > nums[hi]){
                lo = mid + 1;
            }else{
                hi = mid;
            }
        }
        int minimumIndex = lo;

        // 2.是否找到
        if(nums[minimumIndex] == target){
            return minimumIndex;
        }

        // 3.确定target在哪一段
        int realLow = -1;
        int realHigh = -1;
        if(target > nums[nums.length - 1]){
            realLow = 0;
            realHigh = minimumIndex -1;
        }else{
            realLow = minimumIndex;
            realHigh = nums.length - 1;
        }
        // 4. 开始真正的二分查找
        int result = -1;
        while(realLow <= realHigh){
            int realMid = (realLow + realHigh)/2;
            if(nums[realMid] == target){
                result = realMid;
                break;
            }
            if(target > nums[realMid]){
                realLow = realMid + 1;
            }else{
                realHigh = realMid - 1;
            }
        }
        return result;
    }

    @Test
    public void test(){
        int[] nums = new int[]{4,5,6,7,0,1,2};
        assertEquals(0, search(nums, 4)); 
        assertEquals(4, search(nums, 0)); 
    }
}