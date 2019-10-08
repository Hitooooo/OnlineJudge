package com.leetcode.top100.medium;

import java.util.LinkedList;

/**
 * 判断有向图是否是 有向无环图（DAG）
 * 
 * @author hitomeng
 * @date 2019/10/08
 */
public class CourseSchedule207 {

    /**
     * 找到入度为零的结点，入栈。依次弹栈，并将结点从有向图中删除，然后将新的入度为零的结点入栈。
     * 最终如果能将所有的结点全部删除，那么就是有向无环图。
     * 注意：题中的输入关系是 前面依赖后面
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 1. 计算每个结点的入度
        int[] degrees = new int[numCourses];
        for (int[] prerequisity : prerequisites) {
            degrees[prerequisity[0]]++;
        }

        // 2. 找到入度为零的结点，添加进queue
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < degrees.length; i++) {
            if (degrees[i] == 0) {
                queue.addLast(i);
            }
        }

        while (!queue.isEmpty()) {
            // 3. 删除入度为零的结点
            int delete = queue.removeFirst();
            numCourses--;
            // 4. 计算删除后的相关结点的入度，如果为零再次入队列
            for (int[] prerequisity : prerequisites) {
                if (prerequisity[1] == delete) {
                    int nextNode = prerequisity[0];
                    degrees[nextNode]--;
                    if(degrees[nextNode] == 0){
                        queue.addLast(nextNode);
                    }
                }
            }
        }
        return numCourses == 0;
    }
}