package com.leetcode.top100.medium;

/**
 * Given an array of integers nums sorted in ascending order, find the starting
 * and ending position of a given target value.Your algorithm's runtime
 * complexity must be in the order of O(log n).If the target is not found in the
 * array, return [-1, -1].
 * 
 * 在已排序的数组（元素可重复）中，找到一个元素所在的位置，如果有多个则返回其起止位置 Input: nums = [5,7,7,8,8,10],
 * target = 8 Output: [3,4]
 * 
 * @author hitomeng
 * @date 2019/09/05
 */
public class RangeInSortedArray {

    /**
     * 方法1：双指针，头尾同时遍历。时间复杂度 O（n） 方法二：两次二分查找，一次确定左面，一次确定右面
     */
    public int[] searchRange(int[] nums, int target) {
        return null;
    }

    public int binarySearchLeft(int[] nums, int target) {

        return -1;
    }

    public int binarySearchRight(int[] nums, int target) {
        return -1;
    }

}