package com.challenge.tree;

import com.challenge.leetcode.topquestions.*;

import java.util.*;

public class BottomViewBinaryTree {

    public static void bottomViewBinaryTree(TreeNode root) {

        if (root == null) {
            return;
        }
        Map<Integer, TreeNode> distanceMap = new TreeMap<>();
        Queue<VerticalOrderTraversal.TreeNodeDistance> queue = new LinkedList<>();
        queue.add(new VerticalOrderTraversal.TreeNodeDistance(root, 0));
        while (!queue.isEmpty()) {
            VerticalOrderTraversal.TreeNodeDistance nodeDistObj = queue.poll();
            distanceMap.put(nodeDistObj.distance, nodeDistObj.node);

            if (nodeDistObj.node.left != null) {
                queue.add(new VerticalOrderTraversal.TreeNodeDistance(root, nodeDistObj.distance - 1));
            }

            if (nodeDistObj.node.right != null) {
                queue.add(new VerticalOrderTraversal.TreeNodeDistance(root, nodeDistObj.distance + 1));
            }
        }
        //print the nodes
        distanceMap.values().forEach(v -> System.out.println(v));

    }

    public static void main(String[] args) {
        BuildBinaryTree bt = new BuildBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.right = new TreeNode(8);

        bottomViewBinaryTree(root);
    }
}
