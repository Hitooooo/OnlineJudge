package com.offer.tree.traverse;

import java.util.ArrayList;
import java.util.LinkedList;

import com.leetcode.struct.TreeNode;

import org.junit.Test;

/**
 * 层序遍历二叉树
 * 
 * @author hitomeng
 * @date 2020-04-11 10:46:10
 */
public class Layer {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();
            res.add(queue.pop().val);
            if (node.left != null) {
                queue.addLast(node.left);
            }
            if (node.right != null) {
                queue.addLast(node.right);
            }
        }
        return res;
    }

    /**
     * 层序遍历时，下一层需要换行
     * 
     * @param root
     * @return
     */
    public void PrintFromTopToBottom2(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        int needPrintCount = 1;
        int nextLayerCount = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();
            System.out.print(node.val+"\t");
            needPrintCount--;
            if (node.left != null) {
                queue.addLast(node.left);
                nextLayerCount++;
            }
            if (node.right != null) {
                queue.addLast(node.right);
                nextLayerCount++;
            }
           if(needPrintCount == 0){
               System.out.println();
               needPrintCount = nextLayerCount;
               nextLayerCount = 0;
           } 
        }
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(8);
        TreeNode n1 = new TreeNode(6);
        TreeNode n2 = new TreeNode(10);
        root.left = n1;
        root.right = n2;
        n1.left = new TreeNode(5);
        n1.right = new TreeNode(7);

        n2.left = new TreeNode(100);
        n2.right = new TreeNode(200);

        PrintFromTopToBottom2(root);
    }
}