package com.offer.sword;

import com.leetcode.struct.TreeLinkNode;
import org.junit.Test;

/**
 * 给定一个二叉树和二叉树中的某个节点，找到其按中序或者前序遍历的后一个节点
 * 
 * @author hitomeng
 * @date 2020/01/28
 */
public class NextNodeInBTree {
    /**
     * 中序遍历结果中，某个节点的下一个节点. 中序情况下，最一般的考虑，结点的下一个结点就是右子树的最左孩子。
     * 如果右子树为空，需要向上从父节点中选择下一个节点。分为：当前节点是左孩子还是右孩子
     * 
     * @param pNode 指定的节点
     */
    public TreeLinkNode NextInOrder(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        TreeLinkNode next = null;
        if (pNode.right != null) {
            TreeLinkNode right = pNode.right;
            while (right.left != null) {
                right = right.left;
            }
            next = right;
        } else if(pNode.parent != null && pNode.parent.left == pNode){
            // 当前节点是父节点的左孩子
            next = pNode.parent;
        }else if(pNode.parent != null && pNode.parent.right == pNode){
            // 当前节点是父节点的右孩子，向上寻找
            TreeLinkNode current = pNode;
            TreeLinkNode parent = pNode.parent;
            while(parent != null && parent.right == current){
                current = current.parent;
                parent = current.parent;
            }            
            next = parent;
        }

        return next;
    }

    /***
     * 后序遍历的下一个.
     * 1. 如果非叶子节点
     *   如果有左孩子就是左，有右孩子就是右
     * 2. 叶子节点
     *  2.1 是父节点的左孩子
     *      向上寻找右孩子不为空的父节点
     *  2.2 是父节点的右孩子，说明该颗子树遍历完成，需要进入右子树
     *      向上寻找右孩子不为空的父节点
     *  也就是向上寻找右孩子不为空且右孩子不是当前节点的父节点，找到的父节点的右孩子就是next节点
     */
    public TreeLinkNode AferOrder(TreeLinkNode pNode){
        if (pNode == null) {
            return null;
        }

        if(pNode.left != null){
            return pNode.left;
        }

        if(pNode.right != null){
            return pNode.right;
        }

        // 左右都为空，向上寻找右孩子不为空，且右孩子不是当前节点的父节点
        TreeLinkNode current = pNode;
        TreeLinkNode parent = pNode.parent;
        while(parent != null && (parent.right == null || parent.right == current)){
            current = current.parent;
            parent = current.parent;
        }

        return parent == null ? null : parent.right;
    }

    @Test
    public void test() {
        TreeLinkNode root = new TreeLinkNode(0);
        TreeLinkNode n1 = new TreeLinkNode(1);
        TreeLinkNode n2 = new TreeLinkNode(2);
        TreeLinkNode n3 = new TreeLinkNode(3);
        TreeLinkNode n4 = new TreeLinkNode(4);
        TreeLinkNode n5 = new TreeLinkNode(5);
        TreeLinkNode n6 = new TreeLinkNode(6);
        root.left = n1;
        root.right = n2;

        n1.parent = root;
        n2.parent = root;
        n1.left = n3;
        n1.right = n4;
        n3.parent = n1;
        n4.parent = n1;

        n2.left = n5;
        n2.right = n6;
        n5.parent= n2;
        n6.parent = n2;


        TreeLinkNode next = NextInOrder(n3);        
        TreeLinkNode next1 = AferOrder(n6);
        System.out.println(next.val);
        System.out.println(next1.val);

    }
}