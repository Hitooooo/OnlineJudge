package com.leetcode.top100.medium;

import java.util.HashMap;
import org.junit.Test;

/**
 * Given an array of integers and an integer k, you need to find the total
 * number of continuous subarrays whose sum equals to k.
 * 
 * @author hitomeng
 * @date 2019/12/23
 */
public class SubarraySumEqualsK560 {

    /**
     * sum[i] = n[0] + n[1] +...+n[i],连续子数组的和为target 那么 存在 sum[j] - sum[i] = K,转换下
     * 存在 sum[j] - k = sum[i]. 计算前缀和时，如果前面的和中有等于sum[j] - k 的,那么解数加一
     * 
     */
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        // 边界值处理
        if (nums == null || nums.length == 0) {
            return map.get(0);
        }
        int sum = 0;
        int count = 0;
        for(Integer i : nums){
            sum += i;
            // 计算满足 sum[j] - k = sum[i] 的个数
            if(map.containsKey(sum - k)){
                count+= map.get(sum - k);
            }
            // 记录前缀和的个数
            if(map.containsKey(sum)){
                int old = map.get(sum);
                map.put(sum, old + 1);
            }else{
                map.put(sum, 1);
            }
        }
        return count;
    }

    @Test
    public void test(){
        int[] arr = {1, 1, 1, 1};
        int res = subarraySum(arr, 3);
        System.out.println(res);
    }
}