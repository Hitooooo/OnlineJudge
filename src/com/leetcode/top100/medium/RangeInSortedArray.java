package com.leetcode.top100.medium;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

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
        int[] result = new int[]{-1, -1};
        result[0] = binarySearchLeft(nums, target);
        result[1] = binarySearchRight(nums, target);
        return result;
    }

    /**
     * target>nums[mid] lo++ target<nums[mid] hi--
     * 关键是两者相等的时候，因为数组已经被排序，所以mid要么是起点要么起点在mid的左面。这个时候缩小范围，让hi==mid，保证起点的同时缩小右侧。
     */
    public int binarySearchLeft(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target) {
                hi = mid;
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return nums[lo] != target ? -1 : lo;
    }

    /**
     * 与上面同样的道理，注意计算mid的不同。
     * 当nums[mid] == target,缩小左侧范围
     */
    public int binarySearchRight(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            //保证偶数个数的时候，mid指向原来的后一个
            int mid = (lo + hi + 1) / 2;
            if (nums[mid] == target) {
                lo = mid;
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return nums[hi] != target ? -1 : hi;

    }

    @Test
    public void testLeft() {
        int[] arr = new int[] { 0, 0, 0, 0 };
        assertEquals(0, binarySearchLeft(arr, 0));
        assertEquals(-1, binarySearchLeft(arr, 1));
        assertEquals(3, binarySearchRight(arr, 0));
        assertEquals(-1, binarySearchRight(arr, 1));
    }
}