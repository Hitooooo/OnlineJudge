package com.leetcode.top100.medium;

import org.junit.Test;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数0、 1 和 2 分别表示红色、白色和蓝色。 
 * 注意:不能使用代码库中的排序函数来解决这道题。
 * 
 * @author hitomeng
 * @since 2019/09/16
 */
public class SortColors {

    /**
     * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色 
     * 双指针：redPointRight bulePointLeft
     * 判断每个元素的性质后，与两个指针交换位置，剩下的自然会放在中间位置
     */
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int redPointRight = 0;
        int bulePointLeft = nums.length - 1;
        int current = 0;
        
        // 判断条件，需要判断的元素的下标是否到达蓝色左边界
        while (current <= bulePointLeft) {
            int temp = nums[current];
            if (nums[current] == 0) {
                // 红色，交换 自增
                nums[current] = nums[redPointRight];
                nums[redPointRight++] = temp;
                current++;
            } else if (nums[current] == 2) {
                // 蓝色，交换，但是current不变，因为交换后的那个数还需要判断是什么
                nums[current] = nums[bulePointLeft];
                nums[bulePointLeft--] = temp;
            }else{
                // 白色，不变两个指针，current指向下一个即可
                current++;
            }
        }
    }

    @Test
    public void test(){
        int[] arr =  new int[]{2,0,2,1,1,0};
        sortColors(arr);
        System.out.println(arr);
    }
}