package com.leetcode;


/**
 * @author Mht
 */
public class Main {

    public static void main(String[] args) {
        System.out.printf(new FindAnagrams().findAnagrams2("cbaebabacd", "abc").toString());
        int[] arr = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        new FindNumbersDisappeared().findDisappearedNumbers(arr);
    }
}
