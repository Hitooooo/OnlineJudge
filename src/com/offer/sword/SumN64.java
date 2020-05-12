package com.offer.sword;

/**
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 * 
 * @author hitomeng
 * @date 2020-05-11 22:29:27
 */
public class SumN64 {

    /**
     * 递归版本
     */
    public int Sum_Solution(int n) {
        if (n == 1) {
            return 1;
        }
        return n + Sum_Solution(n - 1);
    }

    public int sum2(int n) {
        int res = n;
        boolean b = n > 0 && ((res += sum2(n - 1)) > 0);
        return res;
    }
}