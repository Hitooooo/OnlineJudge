package com.leetcode.top100.easy;

/**
 * You're given strings J representing the types of stones that are jewels, and
 * S representing the stones you have. Each character in S is a type of stone
 * you have. You want to know how many of the stones you have are also jewels.
 * The letters in J are guaranteed distinct, and all characters in J and S are
 * letters. Letters are case sensitive, so "a" is considered a different type of
 * stone from "A".
 * 
 * eg:
 * 
 * Input: J = "aA", S = "aAAbbbb" Output: 3
 */

public class Jewels {

    /**
     * 直观的想法就是遍历判断是否存在
     * 
     * @param J jewels
     * @param S stone
     * @return num of jewels you have
     */
    public int numJewelsInStones(String J, String S) {
        if (J == null || J.isEmpty()) {
            return 0;
        }

        if (S == null || S.isEmpty()) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            if (J.contains(S.charAt(i) + "")) {
                count++;
            }
        }
        return count;
    }

    /**
     * 其实jewels的种类不多，就52种（26+26），可以通过ASCII表计算出ASCII码后存入数组。 需要判断的石头遍历后
     * 判断对应数组下标的值是否为零。
     * 注意：虽然种类只有52种，但是大小写字母的ASCII码不是连续的中间有非字母符号6个，为了统一计算，申请数组大小为52+6=58
     * 到这里你也应该明白：大小写转换是加减32（26+6）
     * 
     * @param J jewels
     * @param S stone
     * @return num of jewels you have
     */
    public int numJewelsInStones2(String J, String S) {
        if (J == null || J.isEmpty()) {
            return 0;
        }

        if (S == null || S.isEmpty()) {
            return 0;
        }

        int count = 0;
        int[] jewels = new int[58];
        for (char j : J.toCharArray()) {
            jewels[j - 65]++;
        }

        for (char s : S.toCharArray()) {
            // 优化下，减少比较次数
            /* if (jewels[s - 65] > 0) {
                count++;
            } */
            count += jewels[s -65];
        }
        return count;
    }
}