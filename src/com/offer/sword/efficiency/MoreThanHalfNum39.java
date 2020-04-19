package com.offer.sword.efficiency;

import org.junit.Test;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。 如果不存在则输出0。
 * 
 * @author hitomeng
 * @date 2020-04-19 19:29:26
 */
public class MoreThanHalfNum39 {

    /**
     * 攻城略地
     * @param array 攻城顺序
     * @return 最终人数大于最多的留下
     */
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        // 空城，直接进入
        int count = 1;
        int res = array[0];
        for (int i = 1; i < array.length; i++) {
            // 如果空城，直接进入兵力置为1
            if (count == 0) {
                res = array[i];
                count = 1;
            } else if (array[i] == res) {
                // 来了友军，兵力+1
                count++;
            } else {
                // 敌人来了，兵力减一
                count--;
            }
        }
        int realCount = 0;
        // 判断出现次数，满足题目要求的一半
        for (int i = 0; i < array.length; i++) {
            if (array[i] == res) {
                realCount++;
            }
        }
        return realCount > array.length / 2 ? res : 0;
    }

    @Test
    public void test(){
        int res = MoreThanHalfNum_Solution(new int[]{1,2,2});
        System.out.println(res);
    }
}