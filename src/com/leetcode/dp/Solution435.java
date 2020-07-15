package com.leetcode.dp;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 * 注意:可以认为区间的终点总是大于它的起点。区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 */
public class Solution435 {

    /**
     * 移除区间的最小数量，也就是保留最多数量的不重叠区间
     *
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        int remainCount = 1;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int x = intervals[0][1];
        for (int[] interval : intervals) {
            if (interval[0] >= x) {
                x = interval[1];
                remainCount++;
            }
        }
        return intervals.length - remainCount;
    }

    @Test
    public void test() {

        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        int i = eraseOverlapIntervals(intervals);
        System.out.println(i);
    }

}