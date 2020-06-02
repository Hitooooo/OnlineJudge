package com.offer.sword.quality;

import java.util.Arrays;

import org.junit.Test;


/**
 * 输入数字n，按顺序打印出从1到最大的n位十进制数。 比如输入3，则打印1、2、3一直到最大的三位数999
 * 
 * @author hitomeng
 * @date 2020-03-29 18:08:07
 */
public class Print1ToMaxOfDigits17 {

    /**
     * 考虑通过字符串的形式打印。 char[n].其中的每位上的字符都可能是 1-9，排列出所有可能情况并打印
     * 但是时间复杂度太高
     */
    private void printStr(int n) {
        char[] nums = new char[n];
        helper(nums, 0);
    }

    private void helper(char[] nums, int index) {
        if (index == nums.length) {
            printChar(nums);
            return;
        }
        for (int i = 0; i <= 9; i++) {
            nums[index] = Character.forDigit(i, 10);
            helper(nums, index + 1);
        }
    }

    private void printChar(char[] nums) {
        int startIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > '0') {
                startIndex = i;
                break;
            }
        }
        if(startIndex >= 0){
            System.out.println(new String(Arrays.copyOfRange(nums, startIndex, nums.length)));
        }
    }

    /**
     * n位就构造 n+1位数 如3 就1000，然后循环.如果n很大的话，显然max就会溢出。
     * 
     * @param n 位数
     */
    public void print(int n) {
        int max = 1;
        while (n > 0) {
            max = 10 * max;
            n--;
        }
        for (int i = 1; i < max; i++) {
            System.out.println(i);
        }
    }

    @Test
    public void test() {
        printStr(3);
    }
}