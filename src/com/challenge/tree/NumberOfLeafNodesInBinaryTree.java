package com.challenge.tree;

import com.challenge.leetcode.topquestions.*;

import java.util.*;

public class NumberOfLeafNodesInBinaryTree {

    public int numberOfLeafNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int count = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left == null && node.right == null) {

                count++;
            }
            if (node.left != null) {
                //add to queue
                queue.add(root.left);
            }
            if (node.right != null) {
                //add right to queue
                queue.add(root.right);
            }
        }

        return count;
    }
}
