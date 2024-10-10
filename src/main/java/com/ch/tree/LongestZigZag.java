package com.ch.tree;

/**
 * 1372. 二叉树中的最长交错路径
 */
public class LongestZigZag {
    int maxLength = 0;

    public int longestZigZag(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 从根节点开始递归，尝试从左、右两个方向出发
        dfs(root, 0, 0); // 从根节点开始走
        return maxLength;
    }
    // dfs递归方法，dir表示当前的方向，0表示向左，1表示向右
    private void  dfs(TreeNode root, int direction, int length) {
        if (root == null) {
            return ;
        }
        // 更新最长路径
        maxLength = Math.max(maxLength, length);
        // 如果方向是向左的，接下来应该向右走
        if (direction == 0) {
            dfs(root.left, 1, length + 1); // 向左走，然后要右转
            dfs(root.right, 0, 1); // 从右子树重新开始计数
        }
        // 如果方向是向右的，接下来应该向左走
        else {
            dfs(root.right, 0, length + 1); // 向右走，然后要左转
            dfs(root.left, 1, 1); // 从左子树重新开始计数 重置length
        }
    }
}
