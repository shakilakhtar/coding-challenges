package com.challenge.tree;

import com.challenge.leetcode.topquestions.*;

import java.util.*;

public class TopViewBinaryTree {

    public void topViewBinaryTree(TreeNode root) {
        if (root == null) {
            return;
        }
        Map<Integer, TreeNode> distanceMap = new TreeMap<>();
        Queue<VerticalOrderTraversal.TreeNodeDistance> queue = new LinkedList<>();
        queue.add(new VerticalOrderTraversal.TreeNodeDistance(root, 0));

        while (!queue.isEmpty()) {
            VerticalOrderTraversal.TreeNodeDistance nodeDistObj = queue.poll();
            if (!distanceMap.containsKey(nodeDistObj.distance)) {
                distanceMap.put(nodeDistObj.distance, nodeDistObj.node);
            }

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

    }
}
