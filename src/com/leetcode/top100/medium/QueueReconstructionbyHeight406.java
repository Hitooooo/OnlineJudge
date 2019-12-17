package com.leetcode.top100.medium;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.Test;

/**
 * Suppose you have a random list of people standing in a queue. Each person is
 * described by a pair of integers (h, k), where h is the height of the person
 * and k is the number of people in front of this person who have a height
 * greater than or equal to h. Write an algorithm to reconstruct the queue.
 * 
 * @author hitomeng
 * @date 2019/12/12
 */
public class QueueReconstructionbyHeight406{

    /**
     * 1.按身高排序
     * 2.按排序好的顺序依次添加到新的列表
     * 3.添加规则：people(h,k)添加到K位置。降序插入，新插入的可以保证自己的正确性；
     * 被插入位置前面的people不变，后面的因为插入是小于它的所以也不会错误
     */
    public int[][] reconstructQueue(int[][] people) {
        // 注意如果值相同，那么应该比较位置K，大的放在后面
        Arrays.sort(people, (p1, p2) -> {return p1[0]==p2[0]?p1[1] - p2[1] :p2[0] - p1[0];});
        LinkedList<int[]> list = new LinkedList<>();
        for(int[] p: people){
            list.add(p[1], p);
        }
        
        return list.toArray(people);
    }

    @Test
    public void test(){
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        int[][] res = reconstructQueue(people);
        System.out.println(res);
    }
}