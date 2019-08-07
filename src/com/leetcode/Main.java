package com.leetcode;

import com.leetcode.top100.medium.LongestPalindrome;
import com.leetcode.top100.medium.ThreeSum;

/**
 * @author Mht
 */
public class Main {

    public static void main(String[] args) {
                
        System.out.println(new LongestPalindrome().longestDynamic("abba"));
        System.out.println(new ThreeSum().threeSum(new int[]{-2,0,1,1,2}));
    }
}
