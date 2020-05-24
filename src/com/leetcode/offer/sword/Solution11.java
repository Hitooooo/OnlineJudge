package com.leetcode.offer.sword;

import org.junit.Test;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 * 
 */
public class Solution11 {

    public int minArrayBinary(int[] nums) {
        if (nums == null || nums.length < 1) {
            return Integer.MAX_VALUE;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            // mid可能切在大数组，也可能切在小数组
            int mid = left + (right - left) / 2;
            // 切在大数组
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if(nums[mid] < nums[right]){
                right = mid;
            }else{
                // 无法判断，减一缩小范围同时保证不会跳过最小值
                // 1 2 2 2 2
                // 1 1 0 1
                right--;
            }
        }
        return nums[left];
    }

    /**
     * 找到降序的那个即可，时间复杂度为o(n).既然是已排序的数组，即可以通过二分查找将时间复杂度降到log2n
     */
    public int minArray(int[] numbers) {
        int minIndex = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i + 1] < numbers[i]) {
                minIndex = i + 1;
            }
        }

        return numbers[minIndex];
    }

    @Test
    public void test() {
        int res = minArrayBinary(new int[] { 1, 3, 3, 3, 3, 3, 3 });
        System.out.println(res);
    }
}