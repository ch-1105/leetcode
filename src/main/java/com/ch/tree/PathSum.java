package com.ch.tree;

public class PathSum {
    public int pathSum(TreeNode root, long targetSum) {
        if (root == null) {
            return 0;
        }
        int ret = rootSum(root, targetSum);
        ret += pathSum(root.left, targetSum);
        ret += pathSum(root.right, targetSum);
        return ret;
    }

    public int rootSum(TreeNode root, long targetSum) {
        int ret = 0;

        if (root == null) {
            return 0;
        }
        if (root.val == targetSum) {
            ret++;
        }
        ret += rootSum(root.left, targetSum - root.val);
        ret += rootSum(root.right, targetSum - root.val);
        return ret;
    }
}
