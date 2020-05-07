package com.offer.tree.ques;

import com.common.util.TreeUtils;
import com.leetcode.struct.TreeNode;

import org.junit.Test;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。 在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
 * 
 * @author hitomeng
 * @date 2020-05-07 08:09:54
 */
public class IsBanlanceTree {
    public boolean IsBalanced_Solution(TreeNode root) {
        int[] arr = new int[1];
        return isBanlance(root, arr);
    }

    /**
     * 类似后序遍历，先看左右孩子是否满足，若满足查看当前是否平衡并且记录当前节点的深度 
     *  
     * @param root 二叉树
     * @param depth 参数传递，记录当前节点的深度
     */
    private boolean isBanlance(TreeNode root, int[] depth) {
        if (root == null) {
            depth[0] = 0;
            return true;
        }

        int[] leftDepth = new int[1];
        int[] rightDepth = new int[1];

        if (isBanlance(root.left, leftDepth) && isBanlance(root.right, rightDepth)) {
            int diff = Math.abs(leftDepth[0] - rightDepth[0]);
            depth[0] = Math.max(leftDepth[0], rightDepth[0]) + 1;
            return diff < 2;
        }
        return false;
    }

    @Test
    public void test() {
        Integer[] nums = { 1, 2, 3, 4, 5, null, null, null, null, 6 };
        TreeNode root = TreeUtils.toTree(nums);
        boolean res = IsBalanced_Solution(root);
        System.out.println(res);
    }
}