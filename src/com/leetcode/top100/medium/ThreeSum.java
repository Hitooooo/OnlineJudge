package com.leetcode.top100.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such
 * that a + b + c = 0? Find all unique triplets in the array which gives the sum
 * of zero. Note: The solution set must not contain duplicate triplets. input:
 * [-1, 0, 1, 2, -1, -4], output: [ [-1, 0, 1], [-1, -1, 2] ]
 * 
 * @author hitomeng
 * @date 2019年08月06日22:33:49
 */
public class ThreeSum {

    /**
     * 还能想起来2sum问题吗？ 数组中值为map中的键，index为map中的值。
     * 遍历三个数中的一个，剩下两个就是2sum问题。但是这样会面临重复问题，和为零的三个数会参加三次统计。 能不能用排序解决呢？ 1.
     * 将数组排序，遍历数组元素当作三个中第一个 2. 两个指针指向下一个和最后一个 3. 指针向中间运动，找到了就加入list，然后寻找下一对，直到 i !<
     * j 3.2 如何寻找下一对?i++,j--而且注意跳过重复值
     * 
     * @param nums
     * @return triplets which sum is 0
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return results;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {              // skip same result
                continue;
            }
            int target = 0 - nums[i];
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    results.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    // 跳过重复值，这里的指针 是更新过的
                    /*while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }*/
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                } else if (nums[j] + nums[k] > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return results;
    }
}