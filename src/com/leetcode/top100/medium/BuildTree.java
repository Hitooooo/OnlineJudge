package com.leetcode.top100.medium;

import com.leetcode.struct.TreeNode;

import org.junit.Test;

/**
 * 根据前序和中中序遍历，构造一棵二叉树，其中无重复的值的结点
 *
 * @author hitomeng
 * @since 2019/09/22
 */
public class BuildTree {

    /**
     * 
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    /**
     * 
     * @param preOrder 前序遍历
     * @param inOrdej  中序遍历
     * @param inEnd    子树在中范围中序遍历的结束位置
     * @param preStar  子树在前序遍历中范围的起始位置
     * @param inStart  子树在中序遍历的范围的起始位置
     * @return 目的构造树的根结点
     */
    private TreeNode helper(int[] preOrder, int[] inOrder, int inStart, int inEnd, int preStart, int preEnd) {
        if (inEnd < inStart || preEnd < preStart) {
            return null;
        }
        // 根节点就是前序遍历的第一个
        TreeNode root = new TreeNode(preOrder[preStart]);
        // 找到中序遍历中的根节点，将数分为 左子树 根结点 右子树
        int rootInOrder = inStart;
        while (rootInOrder <= inEnd && inOrder[rootInOrder] != preOrder[preStart]) {
            rootInOrder++;
        }
        int leftLength = rootInOrder - inStart;
        root.left = helper(preOrder, inOrder, inStart, rootInOrder - 1, preStart + 1, preStart + leftLength);
        root.right = helper(preOrder, inOrder, rootInOrder + 1, inEnd, leftLength + preStart + 1, preEnd);
        return root;
    }

    @Test
    public void test() {
        int[] preOrder = new int[] { 3, 9, 20, 15, 7 };
        int[] inOrder = new int[] { 9, 3, 15, 20, 7 };
        buildTree(preOrder, inOrder);
    }
}