package com.offer.tree.traverse;

import java.util.Stack;

import com.leetcode.struct.TreeNode;

/**
 * 二叉树前序遍历.root节点优先遍历，随后是左右孩子节点。
 */
public class PreOrder {
    /**
     * 递归遍历
     * 
     * @param root
     */
    public void preOrderRecursive(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        preOrderRecursive(root.left);
        preOrderRecursive(root.right);
    }

    /**
     * 非递归遍历，通过栈。
     * 
     * @param root
     */
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            System.out.println(node.val);
            if(node.right != null ){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
        }
    }
}