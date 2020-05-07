package com.common.util;

import java.util.LinkedList;
import java.util.Queue;

import com.leetcode.struct.TreeNode;

public class TreeUtils {
    public static TreeNode toTree(Integer[] nums) {
        if (nums.length == 0)
            return null;
        TreeNode head = new TreeNode(nums[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);
        int index = 1; // 当前的数组下标
        while (index < nums.length) {
            TreeNode cur = queue.poll();
            if (nums[index] != null) { // 第一个节点不为null则放到左节点并入队
                TreeNode temp = new TreeNode(nums[index]);
                cur.left = temp;
                queue.offer(temp);
            }
            if (index++ >= nums.length)
                break;
             if ((index < nums.length) && (nums[index] != null)) { // 第一个节点不为null则放到左节点并入队
                TreeNode temp = new TreeNode(nums[index]);
                cur.right = temp;
                queue.offer(temp);
            }
            index++;
        }
        return head;
    }
}