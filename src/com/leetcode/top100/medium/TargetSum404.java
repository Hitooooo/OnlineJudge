package com.leetcode.top100.medium;

/**
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。
 * 现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 * 
 * @author hitomeng
 * @date 2019/12/22
 */
public class TargetSum404{
    public int findTargetSumWays(int[] nums, int S) {
        return backtrace(S,nums,0);
    }

    /**
     * 对于一个数，只有正/负两种状态。res = (sum + n[i]新目标, 剩下的组成个数) + (sum - n[i])
     * 
     * @param sum 目的和
     * @param nums 可用数组
     * @param i 数组下标
     * @return 可组成目标值的搭配个数
     */
    public int backtrace(int sum, int[] nums, int i){
        int count = 0;
        if(i == nums.length - 1){
            // 如果是最后一个数，他决定是否是一个解
            if(sum - nums[i] == 0){
                // 减去自己是0，那么是一个解
                count ++;
            }
            if(sum + nums[i] == 0){
                // 减去自己是0，那么是一个解
                count ++;
            }
            return count;
        }else if(i < nums.length - 1){
            // 如果不是最后一个，那么他的解个数，取决于新目标值下的解个数
            return backtrace(sum - nums[i], nums,i+1) + backtrace(sum + nums[i], nums, i+1);
        }else {
            // 越界，直接返回0即可
            return 0;
        }
    }
}