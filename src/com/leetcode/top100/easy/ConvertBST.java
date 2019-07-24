package com.leetcode.top100.easy;

import com.leetcode.struct.TreeNode;

/**
 * Given a Binary Search Tree (BST),
 * convert it to a Greater Tree such that every key of the original BST
 * is changed to the original key plus sum of all keys greater than the
 * original key in BST.
 * <p>
 * Input: The root of a Binary Search Tree like this:
 * 5
 * /   \
 * 2     13
 * <p>
 * Output: The root of a Greater Tree like this:
 * 18
 * /   \
 * 20     13
 * <p>
 * 这是一棵平衡二叉树，比自己大的节点都在自己的右子树上。
 * 修改顺序很重要，可以破坏原来的BST性质。
 * 写一个方法，返回右子树的和
 *
 * @author HitoM
 * @date 2019/5/27 18:12
 **/
public class ConvertBST {

    private int sum = 0;

    /**
     * 节点的值等于 所有比自己大的节点的值+自己的值
     * <p>
     * 后序遍历：也不行，需要 右 中 左 顺序遍历
     * <p>
     * 中序遍历：不可行
     * 先序遍历：无法确定父节点不行
     * 层序遍历：无法确定父节点，不行
     *
     * @param root tree
     * @return new tree root
     */
    public TreeNode convertBST(TreeNode root) {
        helper(root);
        return root;
    }

    public void helper(TreeNode root) {
        if (root == null) {
            return;
        }

        helper(root.right);

        root.val += sum;
        sum = root.val;

        helper(root.left);
    }
}
