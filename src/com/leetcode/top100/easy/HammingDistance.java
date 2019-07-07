package com.leetcode.top100;

/**
 * The Hamming distance between two integers is the number
 *
 * of positions at which the corresponding bits are different.
 *
 * Given two integers x and y, calculate the Hamming distance.
 *
 * @author HitoM
 * @date 2019/5/27 17:58
 **/
public class HammingDistance {

    /**
     * 异或后，统计1的个数
     * @param x x
     * @param y y
     * @return hamming distance
     */
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count += xor >> i & 1;
        }
        return count;
    }

    public int hammingDistance2(int x, int y) {

        return Integer.bitCount(x ^ y);
    }
}
