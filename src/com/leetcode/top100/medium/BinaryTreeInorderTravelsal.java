package com.leetcode.top100.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import com.leetcode.struct.TreeNode;

import org.junit.Test;

/**
 * 二叉树中序遍历。递归和非递归实现。这里的中指的是父节点在三个当中处在中间位置。
 * 
 * @author hitomeng
 * @since 2019/09/17
 */
public class BinaryTreeInorderTravelsal {

    public List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> temp = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                temp.add(root.val);
                stack.push(root);
                root = root.right;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                root = root.left;
            }
        }
        Collections.reverse(temp);
        return temp;
    }

    /**
     * 非递归的先序遍历呢 
     * a. 遇到一个节点，访问它，然后把它压栈，并去遍历它的左子树； 
     * b.当左子树遍历结束后，从栈顶弹出该节点并将其指向右儿子，继续a步骤；
     * c. 当所有节点访问完即最后访问的树节点为空且栈空时，停止。
     */
    public List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> temp = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                temp.add(root.val);
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                root = root.right;
            }
        }
        return temp;
    }

    /**
     * 一般改为非递归，使用栈来保存需要用到的信息
     */
    public List<Integer> inorderTraversalNoRecursion(TreeNode root) {
        List<Integer> temp = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            temp.add(root.val);
            root = root.right;
        }
        return temp;
    }

    /**
     * 递归实现
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> temp = new ArrayList<>();
        if (root == null) {
            return temp;
        }
        List<Integer> left = inorderTraversal(root.left);
        if (left != null) {
            temp.addAll(left);
        }
        temp.add(root.val);
        List<Integer> right = inorderTraversal(root.right);
        if (right != null) {
            temp.addAll(right);
        }
        return temp;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        root.right = node2;
        node2.left = new TreeNode(3);
        List<Integer> result = preOrderTraversal(root);
        System.out.println(result);
    }
}