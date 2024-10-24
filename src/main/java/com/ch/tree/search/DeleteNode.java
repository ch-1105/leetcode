package com.ch.tree.search;

import com.ch.tree.TreeNode;

public class DeleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)return null;
        if (key > root.val)
            root.right = deleteNode(root.right, key); // 去右子树删除
        else if(key < root.val)
            root.left = deleteNode(root.left, key);  // 去左子树删除

        else  {  // 当前节点就是要删除的节点
            if (root.left == null)   return root.right;      // 情况1，欲删除节点无左子
            else if (root.right == null)  return root.left;  // 情况2，欲删除节点无右子
            else if (root.left!=null && root.right !=null){  // 情况3，欲删除节点左右子都有
                TreeNode node = root.right;
                while (node.left != null)      // 寻找欲删除节点右子树的最左节点
                    node = node.left;
                node.left = root.left;     // 将欲删除节点的左子树成为其右子树的最左节点的左子树
            root = root.right;         // 欲删除节点的右子顶替其位置，节点被删除
            }
        }
        return root;
    }

    public static void main(String[] args) {
        //[5,3,6,2,4,null,7]
        TreeNode treeNode = new TreeNode(0);
//        treeNode.left = new TreeNode(3);
//        treeNode.right = new TreeNode(6);
//        treeNode.left.left = new TreeNode(2);
//        treeNode.left.right = new TreeNode(4);
//        treeNode.right.right = new TreeNode(7);
        System.out.println(new DeleteNode().deleteNode(treeNode, 0));
    }
}
