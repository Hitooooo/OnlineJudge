package com.offer.sword;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

/**
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身， A为1，J为11，Q为12，K为13，而大、小王为 0
 * ，可以看成任意数字。A 不能视为 14。
 * 
 * @author hitomeng
 * @date 2020-05-10 17:26:42
 */
public class ContinousCards61 {

    /**
     * 排序后，最大值和最小值的差应该等于牌的个数。
     * 大小王不参与计算个数，用来补缺少的牌，能补齐就是顺子否则不是。 
     */
    public boolean isStraight(int[] nums) {
        if (nums == null || nums.length < 1) {
            return false;
        }
        Arrays.sort(nums);
        // 大小王个数
        int kingCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                kingCount += 1;
            } else {
                // 如果存在对子，就一定不是顺子
                if (i > 0 && nums[i - 1] == nums[i]) {
                    return false;
                }
            }
        }
        // 顺子长度
        int length = nums[nums.length - 1] - nums[kingCount] + 1;
        // 实际牌的个数
        int realLength = nums.length - kingCount;
        // 王的个数够不够补上
        return length - realLength <= kingCount;
    }

    @Test
    public void test() {
        assertEquals(true, isStraight(new int[] { 1, 2, 3, 4, 5 }));
        assertEquals(false, isStraight(new int[] { 1, 3, 2, 4, 7 }));
        assertEquals(true, isStraight(new int[] { 0, 3, 2, 6, 4 }));
        assertEquals(false, isStraight(new int[] { 0, 3, 1, 6, 4 }));
        assertEquals(false, isStraight(new int[] { 0, 0, 2, 2, 5 }));
    }
}