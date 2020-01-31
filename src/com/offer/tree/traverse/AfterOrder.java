package com.offer.tree.traverse;

import java.util.Stack;

import com.leetcode.struct.TreeNode;

import org.junit.Test;

/**
 * 二叉树后序遍历
 */
public class AfterOrder {
    public void afterOrderRecursive(TreeNode root) {
        if (root == null) {
            return;
        }
        afterOrderRecursive(root.left);
        afterOrderRecursive(root.right);
        System.out.print(root.val+"\t");
    }

    /**
     * 后序遍历是先访问左、右子树,再访问根节点，而在非递归算法中，利用栈回退到时，并不知道是从左子树回退到根节点，
     * 还是从右子树回退到根节点，如果从左子树回退到根节点，此时就应该去访问右子树，而如果从右子树回退到根节点，
     * 此时就应该访问根节点。所以相比前序和后序，必须得在压栈时添加信息，以便在退栈时可以知道是从左子树返回，
     * 还是从右子树返回进而决定下一步的操作。
     */
    public void afterOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        int left = 1;// 在辅助栈里表示左节点
        int right = 2;// 在辅助栈里表示右节点
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer> flagStack = new Stack<Integer>();

        TreeNode node = root;

        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                flagStack.push(left);
                node = node.left;
            }

            //  换成if也是可以的，可以减少外层判断次数
            while (!stack.empty() && flagStack.peek() == right) {
                // 如果是从右子节点返回父节点，则任务完成，将两个栈的栈顶弹出
                flagStack.pop();
                System.out.print(stack.pop().val + "\t");
            }

            if (!stack.empty() && flagStack.peek() == left) {
                // 如果是从左子节点返回父节点，则将标记改为右子节点,转向右子节点
                flagStack.pop();
                flagStack.push(right);
                node = stack.peek().right;
            }
        }
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        TreeNode n10 = new TreeNode(10);
        root.left = n1;
        root.right = n2;

        n1.left = n3;
        n1.right = n4;

        n2.left = n5;
        n2.right = n6;

        n4.right = n8;
        n4.left = n10;
        n6.right = n7;

        n7.right = n9;
        afterOrder(root);
        System.out.println("------------------");
        afterOrderRecursive(root);
    }
}