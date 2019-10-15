package com.leetcode.top100.medium;

import com.leetcode.struct.TreeNode;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。注意自己也可以是自己的祖先。如root是p。left是q，那么ancestor就是root
 * All of the nodes' values will be unique.p and q are different and both values will exist in the binary tree.
 * @author hitomeng
 * @date 2019/10/15
 */
public class LowestCommonAncestor236 {
    private TreeNode result;

    /**
     * 树最适合递归。自上而下也容易想到回溯法
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        backtrace(root, p, q);
        return result;
    }

    private boolean backtrace(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        int left = backtrace(root.left, p, q) ? 1 : 0;
        int right = backtrace(root.right, p, q) ? 1 : 0;
        int mid = (root == p || root == q) ? 1 : 0;

        if (left + right + mid > 1) {
            result = root;
        }
        return  left + right + mid > 0;
    }
}