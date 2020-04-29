package com.offer.sword.efficiency;

import org.junit.Test;

/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * 
 * @author hitomeng
 * @date 2020-04-29 12:11:59
 */
public class UglyNum49 {
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) {
            return -1;
        }
        int[] uglyNums = new int[index];
        uglyNums[0] = 1;
        int nextUglyIndex = 1;

        int u1Index = 0;
        int u2Index = 0;
        int u3Index = 0;

        while (nextUglyIndex < index) {
            int next = Math.min(Math.min(uglyNums[u1Index] * 2, uglyNums[u2Index] * 3), uglyNums[u3Index] * 5);
            uglyNums[nextUglyIndex] = next;
            while (uglyNums[u1Index] * 2 <= next) {
                u1Index++;
            }
            while (uglyNums[u2Index] * 3 <= next) {
                u2Index++;
            }
            while (uglyNums[u3Index] * 5 <= next) {
                u3Index++;
            }
            nextUglyIndex++;
        }
        return uglyNums[nextUglyIndex - 1];
    }

    @Test
    public void test(){
        int res = GetUglyNumber_Solution(15);
        System.out.println(res);
    }
}