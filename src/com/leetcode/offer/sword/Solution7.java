package com.leetcode.offer.sword;

import com.leetcode.struct.TreeNode;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字
 */
public class Solution7 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return buildSubTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildSubTree(int[] preOrder, int[] inOrder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preOrder[preStart]);
        int leftLen = 0;
        while (inOrder[inStart + leftLen] != preOrder[preStart]) {
            leftLen++;
        }
        TreeNode left = buildSubTree(preOrder, inOrder, preStart + 1, preStart + leftLen, inStart, inStart + leftLen - 1);
        TreeNode right = buildSubTree(preOrder, inOrder, preStart + 1 + leftLen, preEnd, inStart + leftLen + 1, inEnd);
        root.left = left;
        root.right = right;
        return root;
    }
}