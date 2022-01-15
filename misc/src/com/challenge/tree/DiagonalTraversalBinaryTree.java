package com.challenge.tree;

import com.challenge.leetcode.topquestions.*;

import java.util.*;

public class DiagonalTraversalBinaryTree {

    public void diagonalTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
//take tree map to keep node distance as sorted order
        Map<Integer, List<TreeNode>> distanceMap = new TreeMap<>();
        Queue<VerticalOrderTraversal.TreeNodeDistance> queue = new LinkedList<>();
        queue.add(new VerticalOrderTraversal.TreeNodeDistance(root, 0));
        while (!queue.isEmpty()) {
            VerticalOrderTraversal.TreeNodeDistance nodeDistObj = queue.poll();
            if (distanceMap.containsKey(nodeDistObj.distance)) {
                List<TreeNode> nodes = distanceMap.get(nodeDistObj.distance);
                nodes.add(nodeDistObj.node);
            } else {
                List<TreeNode> nodeList = new LinkedList<TreeNode>();
                nodeList.add(nodeDistObj.node);
                distanceMap.put(nodeDistObj.distance, nodeList);
            }
            // for every left child add distance by +1
            if (nodeDistObj.node.left != null) {
                queue.add(new VerticalOrderTraversal.TreeNodeDistance(root, nodeDistObj.distance + 1));
            }
            // for right child keep distance same as parent node
            if (nodeDistObj.node.right != null) {
                queue.add(new VerticalOrderTraversal.TreeNodeDistance(root, nodeDistObj.distance));
            }
        }
        //print vertical order
        for (List<TreeNode> nodes : distanceMap.values()) {
            nodes.forEach(v -> {
                System.out.println(v);
            });

        }
    }
}
