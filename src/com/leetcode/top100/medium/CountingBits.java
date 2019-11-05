package com.leetcode.top100.medium;

/**
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num
 * calculate the number of 1's in their binary representation and return them as an array.
 * 
 * @author  hitomeng
 * @date    2019/11/5
 */
public class CountingBits{
    // 偶数=偶数/2的1个数； 奇数=前一个数的1个数+1
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        for(int i = 1; i<=num;i++){
            if(i%2==0){
                res[i] = res[i/2];
            }else{
                res[i] = res[i-1]+1;
            }
        }
        return res;
    }

    // 可以用过位运算，提高效率
    public int[] countBits2(int num) {
        int[] res = new int[num+1];
        for(int i = 1; i<=num;i++){
            res[i] = res[i>>1] + (i&1);
        }
        return res;
    }
}