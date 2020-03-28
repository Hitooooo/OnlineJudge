package com.offer.sword.algorithm;

import org.junit.Test;

/**
 * 
 * 剪绳子。 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18
 * 
 * @author hitomeng
 * @date 2020年3月28日 22:47:21
 */
public class CutString14 {
    /**
     * 定义函数 f(n) = f(n) * f(n - i) 其中i为截取位置，因为要求m>1，所以 0<i<n
     * 
     * @param length 绳子的长度
     * @return 剪完之后，乘积的最大值
     */
    public int matProductAfterCutting(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }
        // dp[i] 长度为i所能剪成的最大值
        int[] dp = new int[length + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        int max = 0;
        // 外层控制dp[i];i->[1,length]
        for (int i = 4; i <= length; i++) {
            max = 0;
            // 内层计算dp[i]
            for (int j = 1; j <= i / 2; j++) {
                int temp = dp[j] * dp[i - j];
                if(temp > max){
                    max = temp;
                }
            }
            dp[i] = max;
        }
        return dp[length];
    }

    @Test
    public void test(){
        int res = matProductAfterCutting(4);
        System.out.println(res);
    }
}