package com.offer.sword;

import java.util.ArrayList;

import org.junit.Test;

/**
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good
 * Luck!
 * 
 * @author hitomeng @date2020-05-09 10:41:00
 */
public class FindContinuousSequence57 {

    /**
     * 快增加，慢减小
     * 
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer>> solution(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (sum < 2) {
            return res;
        }
        int[] nums = new int[sum];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }
        int left = 0;
        int right = 1;

        int tempSum = nums[left] + nums[right];
        // 结束条件，小的数小于目标数的一半。若小的数大于目标数一半，序列和必定大于目标数
        while (right < sum && left < (sum / 2)) {
            if (tempSum <= sum) {
                if(tempSum == sum){
                    ArrayList<Integer> resOne = new ArrayList<>();
                    for (int i = left; i <= right; i++) {
                        resOne.add(nums[i]);
                    }
                    res.add(resOne);
                    System.out.println("add res" + resOne.toString());
                }
                right++;
                tempSum += right == sum ? 0 : nums[right];
            } else {
                System.out.println("left++");
                tempSum -= nums[left];
                left++;

            }
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(solution(15));        
    }
}