package com.leetcode.top100.medium;

import static org.junit.Assert.assertThat;

import org.junit.Test;

import junit.framework.Assert;

/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
 * of line i is at (i, ai) and (i, 0). Find two lines, which together with
 * x-axis forms a container, such that the container contains the most water.
 * 
 * Input: [1,8,6,2,5,4,8,3,7] Output: 49
 * 
 * @author hitomeng
 * @date 2019-07-31 22:09:52
 */
public class WaterContainer {

    /**
     * 容积的大小由 高度和横坐标的长度决定，如何保证面积的大小是线性遍历的。 相同高度比x，相同x比高度
     * 
     * 从两头向中间遍历 1. 这时候长度是最大的,容积也是相对较大的，想要更大的只能是高度更高的 2. 下一个移动矮的那端以找到更高的，容积才有可能是上涨的
     * 3. 有没有可能错过最大的容积呢？
     * 
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int volume = 0;
        while (left != right) {
            volume = Math.max(volume, Math.min(height[left], height[right]) * (right -left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return volume;
    }

    @Test
    public void test(){
        assert(maxArea(new int[]{1,8,6,2,5,4,8}) == 49);
    }
}