package com.offer.sword;

import java.util.Arrays;

/**
 * 数组中重复的数
 * 
 * @author hitomeng
 * @date 2020/1/12
 */
public class DuplicateNumInArray {

    /**
     * 把数组中元素的值就当作其Hash值，value也是元素的值。然后在数组中下标做Hash插入。
     * 时间复杂度 每个元素最多两次交换就处在所在位置，O(n)
     * 空间复杂度 O(1)
     * @param numbers 目标数组
     * @param length 数组长度
     * @param duplication 保存重复的数
     * @return 是否有重复的值
     */
    public boolean duplicateHash(int numbers[], int length, int[] duplication) {
        if (numbers == null || numbers.length < 1) {
            return false;
        }
        
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] < 0 || numbers[i] > length - 1){
                return false;
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            while(i != numbers[i]){
                if(numbers[numbers[i]] == numbers[i]){
                    duplication[0] = numbers[i];
                    return true;
                }

                // 交换 numbers[i]和numbers[numbers[i]]
                int temp = numbers[i];
                numbers[i] = numbers[numbers[i]];
                numbers[temp] = temp;
            }
        }

        return false;
    }

    /**
     * 先排序将相同的数字放在相邻的位置，遍历数组，判断每一个元素是否等于前一个元素。
     */
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if (numbers == null || numbers.length < 1) {
            return false;
        }
        Arrays.sort(numbers);
        int last = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == last) {
                duplication[0] = last;
                return true;
            } else {
                last = numbers[i];
            }
        }
        return false;
    }
}