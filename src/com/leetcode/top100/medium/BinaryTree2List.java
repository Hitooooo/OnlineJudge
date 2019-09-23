package com.leetcode.top100.medium;

import com.leetcode.struct.TreeNode;

/**
 * 给定一个二叉树，原地将它展开为链表。
 * 
 * @author hitomeng
 * @since 2019/09/23
 */
public class BinaryTree2List {

    /**
     * 按题目要求，最终的链表明显是按照先序遍历来的 
     * 1. 找到左子树的最右孩子( ) 
     * 2. 将root的右子树拼接到1中找到的结点的右子树 
     * 3. root的左子树放到右子树位置，左子树置为null
     * 
     * 重复
     * 
     * @param root The tree Hello
     */
    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left == null) {
                root = root.right;
            } else {
                // 找到左子树的最右结点
                TreeNode temp = root.left;
                while (temp.right != null) {
                    temp = temp.right;
                }
                temp.right = root.right;
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
        }
    }
}