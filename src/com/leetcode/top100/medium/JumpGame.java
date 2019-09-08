package com.leetcode.top100.medium;

import org.junit.Test;

/**
 * * 给定一个非负整数数组，你最初位于数组的第一个位置。数组中的每个元素代表你在该位置可以跳跃的最大长度。 判断你是否能够到达最后一个位置。 * *
 * Input: [2, 3, 1, 1, 4] Output: true
 * 
 * @author hitomeng
 * @date 2019/09/08
 */
public class JumpGame {

    /** 
     * 由动态规划方式知，第一个能否到达最后依赖与 1.其后面存在能到达最后2.第一个能到达那一个
    */
    public boolean canJumpGreedy(int[] nums){
        // 离终点越来越远的可用点
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1 ; i >= 0; i--) {
            if(nums[i] + i >= lastPos){
                lastPos = i;
            }
        }
        return lastPos == 0;
    }

    enum Type {
        GOOD, BAD, UNKNOW
    }

    public boolean canJump(int[] nums) {
        Type[] types = new Type[nums.length];
        for (int i = 0; i < nums.length - 1; i++) {
            types[i] = Type.UNKNOW;
        }
        types[nums.length - 1] = Type.GOOD;
        dp(nums, types);
        return types[0] == Type.GOOD;
    }

    /**
     * 我们不需要尝试每一种可能，对于每一个位置，它要么能到最后要么不能到达最后，可以设置为GOOD或者BAD。这样前一个
     * 可以根据下一个GorB决定自己能不能到达最后一个位置。
     */
    public void dp(int[] nums, Type[] types) {
        for (int i = types.length -2 ; i >= 0; i--) {
            int nextStepMax = Math.min(nums[i] + i, nums.length -1);
            types[i] = Type.BAD;
            for (int j= i + 1; j <= nextStepMax; j++) {
               if(types[j] == Type.GOOD){
                   types[i] = Type.GOOD;
                   break;
               } 
            }
        }
    }

    /**
     * 回溯法。尝试在每个位置上下一步的可能走法. 超时
     */
    public boolean canJump2(int[] nums) {
        return canJumpBacktrace(nums, 0);
    }

    public boolean canJumpBacktrace(int[] nums, int position) {
        if (nums[position] + position >= nums.length - 1) {
            return true;
        }
        int nextStepMax = Math.min(nums.length - 1, position + nums[position]);
        for (int i = position + 1; i <= nextStepMax; i++) {
            if (canJumpBacktrace(nums, i)) {
                return true;
            }
        }
        return false;
    }

    /*
     * 可分解成子问题。首先跳一次，然后将跳完的数组递归调用. 审题不清，数组中的元素代表的是可以跳跃的最大长度，而不是唯一长度。
     */
    @Deprecated
    public boolean canJump1(int[] nums) {
        if (nums == null || nums.length < 1) {
            return false;
        }
        return helper(nums, 0);
    }

    @Deprecated
    public boolean helper(int[] nums, int index) {
        int step = nums[index];
        if (step == 0) {
            if (index == nums.length - 1) {
                return true;
            } else {
                return false;
            }
        }
        if (index + step == nums.length - 1) {
            return true;
        } else if (index + step > nums.length - 1) {
            return false;
        } else {
            return helper(nums, index + step);
        }
    }

    @Test
    public void test() {
        int[] arr = new int[] { 3, 2, 1, 0, 4 };
        boolean result = canJump(arr);
        System.out.println(result);
    }
}