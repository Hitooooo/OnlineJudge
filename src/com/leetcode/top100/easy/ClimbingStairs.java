package com.leetcode.top100.easy;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * 其实就是斐波那契数列辣。
 *
 * @author HitoM
 * @date 2019/3/31 10:23
 */
public class ClimbingStairs {

    /**
     * f(n) = f(n-1) + f(n-2)
     *
     * @param n floor
     * @return how many solution to top
     */
    public static int solution(int n) {
        int[] arr = new int[n+1];
        arr[0] = 1;
        arr[1] = 1;
        for(int i = 2;i <= n ;i++){
            arr[i] = arr[i - 1]+ arr[i-2];
        }
        return arr[n];
    }
}
