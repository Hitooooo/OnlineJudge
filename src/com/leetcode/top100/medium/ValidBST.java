package com.leetcode.top100.medium;

import com.leetcode.struct.TreeNode;

/**
 * 验证一棵树是否为二叉排序树（二叉搜索树）
 */
public class ValidBST {

    long max = Long.MIN_VALUE;
    /**
     * 中序遍历时，判断当前root值是否增大了
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 先判断左子树 再判断root 其次是右子树
        return isValidBST(root.left)  && visit(root) && isValidBST(root.right);
    }

    public boolean visit(TreeNode root) {
        if(root.val > max){
            // 增大记录最大值
            max = root.val;
            return true;
        }else{
            // 不满足
            return false;
        }
    }

}