package com.leetcode;

/**
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that
 * adjacent houses have security system connected and it will automatically
 * contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
 * <p>
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 *
 * @author HitoM
 * @date 2019/4/11 19:13
 **/
public class HouseRobber {

    /**
     * 动态规划。 f(n) = max(f(n-1), nums[n]+f(n-2))
     *
     * @param nums certain amount of money of each house
     * @return maximum amount of money you can rob
     */
    public int rob(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] f = new int[nums.length];
        f[0] = nums[0];
        f[1] = Math.max(f[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            f[i] = Math.max(f[i - 2] + nums[i], f[i - 1]);
        }
        return f[nums.length - 1];
    }
}
