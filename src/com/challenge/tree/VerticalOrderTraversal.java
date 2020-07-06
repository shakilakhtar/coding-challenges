package com.challenge.tree;

import com.challenge.leetcode.topquestions.*;

import java.util.*;

public class VerticalOrderTraversal {

    static class TreeNodeDistance {
        TreeNode node;
        int distance;

        public TreeNodeDistance(TreeNode node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public void verticalOrderTraversal(TreeNode root) {

        if (root == null) {
            return;
        }
        //take tree map to keep node distance as sorted order
        Map<Integer, List<TreeNode>> distanceMap = new TreeMap<>();
        Queue<TreeNodeDistance> queue = new LinkedList<>();
        queue.add(new TreeNodeDistance(root, 0));
        while (!queue.isEmpty()) {
            TreeNodeDistance nodeDistObj = queue.poll();
            if (distanceMap.containsKey(nodeDistObj.distance)) {
                List<TreeNode> nodes = distanceMap.get(nodeDistObj.distance);
                nodes.add(nodeDistObj.node);
            } else {
                List<TreeNode> nodeList = new LinkedList<TreeNode>();
                nodeList.add(nodeDistObj.node);
                distanceMap.put(nodeDistObj.distance, nodeList);
            }

            if (nodeDistObj.node.left != null) {
                queue.add(new TreeNodeDistance(root, nodeDistObj.distance - 1));
            }

            if (nodeDistObj.node.right != null) {
                queue.add(new TreeNodeDistance(root, nodeDistObj.distance + 1));
            }
        }
        //print vertical order
        for (List<TreeNode> nodes : distanceMap.values()) {
            nodes.forEach(v -> {
                System.out.println(v);
            });

        }
    }

    public static void main(String[] args) {

    }
}