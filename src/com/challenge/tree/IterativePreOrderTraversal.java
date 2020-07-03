package com.challenge.tree;

import com.challenge.leetcode.topquestions.*;

import java.util.*;

public class IterativePreOrderTraversal {

    public void iterativePreOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while ((node != null) || (!stack.isEmpty())) {
            if (node != null) {
                System.out.println(node.val);
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                node = node.right;
            }
        }
    }
}
