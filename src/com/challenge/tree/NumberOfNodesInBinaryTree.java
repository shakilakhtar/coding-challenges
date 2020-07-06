package com.challenge.tree;

import com.challenge.leetcode.topquestions.*;

import java.util.*;

public class NumberOfNodesInBinaryTree {

    public int numberOfNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int count = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            count++;
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
