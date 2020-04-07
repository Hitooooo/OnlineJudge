package com.offer.sword.quality;

/**
 * 数值的整数次方。
 */
public class Power16 {

    /**
     * 注意base和exponent不能同时为0. 0^0是没有意义的
     * 
     * @param base    计算次方的底数，可为正数、负数和0
     * @param exponet 可为正数、负数和0
     * @return
     */
    public double me(double base, int exponet) {
        if (base == 0 && exponet == 0) {
            throw new RuntimeException("input param error!");
        }
        if (base == 0) {
            if (exponet < 0) {
                throw new RuntimeException("input param error!");
            }
        }
        if(exponet == 0){
            return 0;
        }
        double res = 1;
        int pow = Math.abs(exponet);
        while(pow > 0){
            res = res * base;
            pow --;
        }
        return exponet > 0 ? res : (1.0/res);
    }
}