package com.offer.sword.efficiency;

import org.junit.Test;

/**
 * 在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。给一个数组，返回它的最大连续子序列的和
 * 
 * @author hitomeng
 * @date 2020-04-25 15:04:08
 */
public class MaxSubArray43 {
    /**
     * f[i] = max((f[i-1]+arr[i]), arr[i]) 其中f[i]表示以
     * arr[i]结尾的最大子数组和。在求f[i]过程中记录最大的子数组和即可
     * 
     * @param array 原数组
     * @return 最大子数组和
     */
    public int findGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) {
            throw new RuntimeException();
        }
        int res = array[0];
        int lastSubMax = array[0];
        for (int i = 1; i < array.length; i++) {
            lastSubMax = Math.max(array[i], lastSubMax + array[i]);
            if (lastSubMax > res) {
                res = lastSubMax;
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(findGreatestSumOfSubArray(arr));
    }
}