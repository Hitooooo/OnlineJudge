package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Given an array of size n, find the majority element.
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *
 * @author HitoM
 * @date 2019/4/11 11:55
 **/
public class MajorityElement {

    /**
     * HashMap.key=num value=出现次数。遍历HashMap找出value> n/2的key
     *
     * @param nums numbers
     * @return majority
     */
    public int majorityElement(int[] nums) {
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }

            if (map.get(num) > nums.length / 2) {
                result = num;
                break;
            }
        }
        return result;
    }

    /* 摩尔投票算法 */
    public int mojroityElement2(int[] nums) {
        int candidate = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
}
