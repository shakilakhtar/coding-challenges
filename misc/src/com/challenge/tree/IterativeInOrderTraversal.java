package com.challenge.tree;

import com.challenge.leetcode.topquestions.*;

import java.util.*;

public class IterativeInOrderTraversal {
    public void iterativeInOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while ((node != null) || (!stack.isEmpty())) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                System.out.println(node.val);
                node = node.right;
            }
        }
    }
}
