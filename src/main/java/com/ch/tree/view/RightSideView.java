package com.ch.tree.view;

import com.ch.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>(10);
        dfs(root, 0, res);
        return res;
    }

    private void dfs(TreeNode root, int level, List<Integer> res) {
        if (root == null) return;
        if (level >= res.size()) {
            res.add(root.val);
        } else {
            res.set(level, root.val);
        }
        dfs(root.left, level + 1, res);
        dfs(root.right, level + 1, res);
    }

    public static void main(String[] args) {
        //1,2,3,null,5,null,4
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        RightSideView rightSideView = new RightSideView();
        System.out.println(rightSideView.rightSideView(root));
    }
}
