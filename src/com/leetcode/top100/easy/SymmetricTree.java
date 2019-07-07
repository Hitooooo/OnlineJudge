package com.leetcode;

import com.leetcode.struct.TreeNode;

/**
 * @author HitoM
 * @date 2019/4/1 10:20
 */
class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return equals(root.left, root.right);
    }

    public boolean equals(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val
                && equals(left.left, right.right)
                && equals(left.right, right.left);
    }
}

