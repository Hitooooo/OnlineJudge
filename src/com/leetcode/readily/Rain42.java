package com.leetcode.readily;

public class Rain42{

    /**
     * 一座山的，前面和后面有许多小坑，计算坑中所有水体积。
     */
    public int trap(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }
        int maxHeightIndex = 0;
        int maxHeight = height[0];
        for (int i = 1; i < height.length; i++) {
            if (height[i] > maxHeight) {
                maxHeightIndex = i;
                maxHeight = height[i];
            }
        }

        // 左侧
        int rain = 0;
        int b = 0;
        for (int a = 0; a <= maxHeightIndex; a++) {
            if (height[b] > height[a]) {
                rain += height[b] - height[a];
            } else {
                b = a;
            }
        }
        // 右侧
        int k = height.length - 1;
        for (int j = height.length - 1; j >= maxHeightIndex; j--) {
            if (height[j] < height[k]) {
                rain += height[k] - height[j];
            } else {
                k = j;
            }
        }
        return rain;
    }
}