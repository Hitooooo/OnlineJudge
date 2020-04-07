package com.offer.tree.traverse;

import java.util.LinkedList;

import com.leetcode.struct.TreeNode;

/**
 * 二叉树中序遍历
 */
public class InOrder{
    public void inOrderRecursive(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderRecursive(root.left);
        System.out.println(root.val);
        inOrderRecursive(root.right);
    }

    /**
     * 每到一个节点 A，因为根的访问在中间，将 A 入栈。然后遍历左子树，接着访问 A，最后遍历右子树。
     * 在访问完 A 后，A 就可以出栈了。因为 A 和其左子树都已经访问完成。
     * @param root 树的根节点
     */
    public void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        TreeNode node = root;
        LinkedList<TreeNode> stack = new LinkedList<>();
        while(node != null || !stack.isEmpty()){
            // 先处理左孩子
            while(node != null){
                stack.push(node);
                node = node.left;
            }
            // 遍历当前节点 
            node = stack.pop();
            System.out.println(node.val);
            // 转向右子树处理,如果node为空，也就是当前子树遍历完毕，需要从栈中弹出下一个中间节点处理.
            node = node.right;
        }
    }

}