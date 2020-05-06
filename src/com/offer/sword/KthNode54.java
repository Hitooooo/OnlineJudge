package com.offer.sword;

import java.util.LinkedList;

import com.leetcode.struct.TreeNode;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8） 中， 按结点数值大小顺序第三小结点的值为4。
 * 
 * @author hitomeng
 * @date 2020-05-06 22:58:50
 */
public class KthNode54 {

    /**
     * 中序遍历即可
     * 
     * @param pRoot
     * @param k
     * @return
     */
    public TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null) {
            return null;
        }
        int index = 0;
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode node = pRoot;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (index == k) {
                return node;
            }
            index++;
            node = node.right;
        }
        return null;
    }
}