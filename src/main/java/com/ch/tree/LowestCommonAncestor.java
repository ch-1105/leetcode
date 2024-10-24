package com.ch.tree;

public class LowestCommonAncestor {
    /**
     * 如果当前节点 root 为空或等于 p 或 q，返回 root。
     * 递归查找左子树和右子树中的最低公共祖先。
     * 如果左右子树都未找到，返回 null。
     * 如果只有左子树找到，返回左子树的结果。
     * 如果只有右子树找到，返回右子树的结果。
     * 如果左右子树都找到，返回当前节点 root。
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (right == null && left == null) {
            return null;
        }
        if (right == null) {
            return left;
        }
        if (left == null) {
            return right;
        }
        return root;
    }


}
