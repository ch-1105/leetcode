package com.ch.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 1448. 统计二叉树中好节点的数目
 root =
 [2,null,4,10,8,null,null,4]
 */
public class GoodNodes {
//    public static int goodNodes(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        int res = 1;
//        ArrayDeque<Integer> deque = new ArrayDeque<>();
//        deque.addFirst(root.val);
//        return dfs(root,res,deque);
//    }
//
//    public static int dfs(TreeNode root , int res , ArrayDeque<Integer> deque) {
//        if (root.left != null) {
//            if (root.left.val >= deque.getLast()) {
//                res++;
//                if (root.left.left != null || root.left.right != null) {
//                    deque.addLast(root.left.val);
//                }
//            }
//            res = dfs(root.left,res,deque);
//        }
//        if (root.right != null) {
//            if (root.right.val >= deque.getLast()) {
//                res++;
//                if (root.right.left != null || root.right.right != null) {
//                    deque.addLast(root.right.val);
//                }
//            }
//            res = dfs(root.right,res,deque);
//        }
//        return res;
//    }

    public static int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        return dfs(root,res,deque);
    }

    public static int dfs(TreeNode root, int res, ArrayDeque<Integer> deque) {
        if (root == null) return res; // 基本情况

        // 检查当前节点是否应该被计数
        if (deque.isEmpty() || root.val >= deque.peekLast()) {
            res++;
            deque.addLast(root.val); // 将当前节点值加入deque
        }

        // 递归遍历左右子树
        res = dfs(root.left, res, deque);
        res = dfs(root.right, res, deque);

        // 回溯时移除当前节点值
        if (!deque.isEmpty() && deque.peekLast() == root.val) {
            deque.removeLast();
        }

        return res;
    }

    public static void main(String[] args) {
        // [2,null,4,10,8,null,null,4]
        TreeNode node = new TreeNode(2);
        node.right = new TreeNode(4);
        node.right.left = new TreeNode(10);
        node.right.right = new TreeNode(8);
        node.right.right.left = new TreeNode(4);
        System.out.println(goodNodes(node));
    }
}
