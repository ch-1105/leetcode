package com.ch.tree;

public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
         return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));

        // 广度优先遍历
        //  if (root == null) {
        //            return 0;
        //        }
        //        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        //        queue.offer(root);
        //        int ans = 0;
        //        while (!queue.sisEmpty()) {
        //            int size = queue.size();
        //            while (size > 0) {
        //                TreeNode node = queue.poll();
        //                if (node.left != null) {
        //                    queue.offer(node.left);
        //                }
        //                if (node.right != null) {
        //                    queue.offer(node.right);
        //                }
        //                size--;
        //            }
        //            ans++;
        //        }
        //        return ans;

    }
}
