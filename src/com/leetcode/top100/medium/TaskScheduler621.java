package com.leetcode.top100.medium;

import java.util.Arrays;

import org.junit.Test;

/**
 * 给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26
 * 种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。 CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。
 * 然而，两个相同种类的任务之间必须有长度为 n 的冷却时间， 因此至少有连续 n 个单位时间内 CPU
 * 在执行不同的任务，或者在待命状态。你需要计算完成所有任务所需要的最短时间。
 * 
 * @author hitomeng
 * @date 2019/12/25
 */
public class TaskScheduler621 {

    /**
     * 确定次数最多的任务，然后将后面的任务插入到最多次任务中间。
     * 设定一轮可执行任务个数为 n+1，一个任务执行后接着运行不同的任务，这一轮中绝不会出现待命的状态。如果每一轮中都没有待命状态，
     * 那么运行时间一定是最小的。但是如果任务种类不够n+1怎么办？选择全部的t种放进去，剩下的空闲
     * 1.排序
     * 2. 
     */
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c: tasks)
            map[c - 'A']++;
        Arrays.sort(map);
        int time = 0;
        while (map[25] > 0) {

        }
        return time; } 
    @Test
    public void test(){
        char[] tasks = {'A','A','A','B','B','B'};
        int time = leastInterval(tasks, 2);
        System.out.println(time);
    }
}