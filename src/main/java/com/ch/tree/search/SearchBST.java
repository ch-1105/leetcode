package com.ch.tree.search;

import com.ch.tree.TreeNode;

public class SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        return searchBST(root.val > val ? root.left : root.right, val);
    }
}
