package com.ch.tree;

import java.util.ArrayDeque;
import java.util.Objects;

public class LeafSimilar {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayDeque<Integer> node1 = new ArrayDeque<>();
        ArrayDeque<Integer> node2 = new ArrayDeque<>();
        traversalTree(root1, node1);
        traversalTree(root2, node2);
        if (node2.size() != node1.size()) {
            return false;
        }
        while (!node1.isEmpty()&& !node2.isEmpty()){
            if (!Objects.equals(node1.poll(), node2.poll())) return false;
        }
        return node1.isEmpty() && node2.isEmpty();
    }

    public void traversalTree(TreeNode node, ArrayDeque<Integer> nodeEnd){
        if (node.left == null && node.right == null) {
            nodeEnd.addLast(node.val);
        }
        if (node.left != null) {
            traversalTree(node.left, nodeEnd);
        }
        if (node.right != null) {
            traversalTree(node.right, nodeEnd);
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        node2.left = new TreeNode(2);
        LeafSimilar leafSimilar = new LeafSimilar();
        System.out.println(leafSimilar.leafSimilar(node, node2));
    }
}
