package com.leetcode.top100.easy;

import com.leetcode.struct.TreeNode;

public class DiameterBinary {

    int max;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }
        
    /**
     * 左右子树的最大高度差即为最大长度。那么如何求最大深度？
     * @return
     */
    private int maxDepth(TreeNode root){
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        // 计算最大深度时，记录两个节点间的最大距离
        max = Math.max(max,left + right);

        // 计算最大深度
        return Math.max(left, right) + 1;
    }
}