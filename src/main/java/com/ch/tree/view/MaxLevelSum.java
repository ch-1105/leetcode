package com.ch.tree.view;

import com.ch.tree.TreeNode;

import java.util.HashMap;

/**
 * BFS
 */
public class MaxLevelSum {
    public int maxLevelSum(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        dfs(root, 1, map);
        int res = 0;
        int maxValue = -0x3f3f3f3f;
        for (int i = 1; i <= map.size(); i++) {
            if (map.get(i) > maxValue) {
                res = i;
                maxValue = map.get(i);
            }
        }
        return res;
    }

    private void dfs(TreeNode root, int level, HashMap<Integer, Integer> map){
        if (root == null) return;
        Integer i = map.get(level);
        if (i != null) {
            i += root.val;
        } else{
            i = root.val;
        }
        map.put(level, i);
        dfs(root.left, level + 1, map);
        dfs(root.right, level + 1, map);
    }

    public static void main(String[] args) {
        //[-100,-200,-300,-20,-5,-10,null]

        TreeNode node = new TreeNode(-100);
        node.left = new TreeNode(-200);
        node.left.left = new TreeNode(-300);
        node.left.left.left = new TreeNode(-20);
        node.left.left.right = new TreeNode(-5);
        node.left.right = new TreeNode(-10);
        System.out.println(new MaxLevelSum().maxLevelSum(node));
    }
}
