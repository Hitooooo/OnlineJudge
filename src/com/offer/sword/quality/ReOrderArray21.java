package com.offer.sword.quality;

import java.util.Arrays;

import org.junit.Test;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * 
 * @author hitomeng
 * @date 2020-04-01 08:42:19
 */
public class ReOrderArray21 {

    /**
     * 是否可以考虑使用选择排序的方式,从后面选择奇数放在前面?不可以，因为选择排序是不稳定排序。
     * 如果考虑排序的方式，还是得插入排序等稳定排序，或者直接空间换时间新建数组先插入奇数然后插入偶数
     * 
     * @param array
     */
    public void reOrderArray2(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int oddLast = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if ((array[j] & 1) != 0) {
                    int temp = array[oddLast];
                    array[oddLast] = array[j];
                    array[j] = temp;
                    oddLast ++;
                    break;
                }
            }
        }
    }

    /**
     * 定义两个搜索指针，p1从数组头部开始搜索指向奇数，p2从尾部开始指向偶数。 不停交换两个指针的位置，直到两者交换位置或错过。
     * 注意这是无法保证稳定性的，也就是说原有的偶数顺序和奇数顺序会被打乱
     * 
     * @param array
     */
    public void reOrderArray(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int p1 = 0;
        int p2 = array.length - 1;
        while (p1 < p2) {
            while (p1 < p2 && (array[p1] & 1) != 0) {
                p1++;
            }
            while (p1 < p2 && (array[p2] & 1) == 0) {
                p2--;
            }
            if (p1 < p2) {
                int temp = array[p1];
                array[p1] = array[p2];
                array[p2] = temp;
            }
        }
    }

    @Test
    public void test() {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7,77,99 };
        reOrderArray2(arr);
        System.out.println(Arrays.toString(arr));
    }
}