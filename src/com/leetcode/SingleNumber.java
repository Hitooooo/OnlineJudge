package com.leetcode;

import java.util.HashSet;

/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 * Input: [2,2,1]
 * Output: 1
 *
 * @author HitoM
 * @date 2019/4/8 17:00
 */
public class SingleNumber {

    /**
     * 题目中是只会出现两次，可以使用 A^B^A = A    A^A=0   0^A=A
     * 所有出现两次的经过异或运算后返回0，0与只出现一次的运算会返回自己
     */
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result = result ^ num;
        }
        return result;
    }

    /**
     * 通过HashSet
     */
    public static int singleNumber1(int[] nums){
        HashSet<Integer> integers = new HashSet<>();
        for (int num : nums) {
            if (integers.contains(num)) {
                integers.remove(num);
            }else{
                integers.add(num);
            }
        }
        return integers.iterator().next();
    }
}
