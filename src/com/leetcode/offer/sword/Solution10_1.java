package com.leetcode.offer.sword;

import org.junit.Test;

public class Solution10_1 {
    public int fib(int n) {
        double[] res = new double[n + 1];
        res[0] = 0;
        res[1] = 1;
        for (int i = 2; i < res.length; i++) {
           res[i] = res[i-1] + res[i-2]; 
        }
        return (int) (res[n] % (1000000007));
    }    

    @Test
    public void test(){
        System.out.println(fib(50));
    }
}