package com.leetcode.top100.medium;

import org.junit.Test;

import java.util.Arrays;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place and use only constant extra memory.
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * <p>
 * 找到当前序列的下一个字典排序序列.
 * <a href="https://en.wikipedia.org/wiki/Permutation#Generation_in_lexicographic_order">Wiki上有完整的介绍</a>
 *
 * @author HitoM
 * @date 2019/9/3 21:51
 **/
public class NextPermutation {

    /**
     * 问题的关键：找到需要交换的两个位置，交换后保证是字典排序的下一个序列。
     * <p>
     * The following algorithm generates the next permutation lexicographically after a given permutation.
     * It changes the given permutation in-place.
     * <p>
     * 1.Find the largest index k such that a[k] < a[k + 1]. If no such index exists, the permutation is the last permutation.
     * 2.Find the largest index l greater than k such that a[k] < a[l].
     * 3.Swap the value of a[k] with that of a[l].
     * 4.Reverse the sequence from a[k + 1] up to and including the final element a[n].
     * <p>
     * 1. 不管是从前面找还是从后面找，找到的K可以理解为 ：k+1->n-1 都是不上升的，即后面都是逆序的
     * 2. 找到满足a[k]<a[l]的l，且l是最大的index，注意是下标不是值.由1知 a[k+1]>a[k],显然l在 [k+1,n-1]的逆序段中
     * 3. 这样 a[l]>a[k]>a[l+1]（如果a[k] < a[l+1]，那么l应该是l+1），交换k与l后，逆序不变
     * 4. 再次反转即为最小字典
     */
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        // 1.确定k
        int k = nums.length - 1;
        int j = k - 1;
        while (j > -1 && nums[j] >= nums[k]) {
            k--;
            j--;
        }
        // 找不到k，反转
        if (j < 0) {
            reverse(nums, 0, nums.length - 1);
            return;
        } else {
            k = j;
        }

        // 2. 确定l
        int l = k + 1;
        while (l < nums.length - 1 && nums[l] > nums[k]) {
            if (nums[l + 1] > nums[k]) {
                l++;
            }else{
                break;
            }
        }

        // 交换k l
        int temp = nums[k];
        nums[k] = nums[l];
        nums[l] = temp;

        // 反转 k到n-1
        reverse(nums, k + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    @Test
    public void test() {
        int[] nums = {2, 3, 1};
        nextPermutation(nums);
        System.out.println(nums);
    }
}
