package com.challenge.tree;

import com.challenge.leetcode.topquestions.*;

import java.util.*;

public class IterativePostOrderTraversal {

    public void iterativePostOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        TreeNode node = root;
        while ((node != null) || (!stack1.isEmpty())) {
            if (node != null) {
                stack2.push(node);
                stack1.push(node);
                node = node.right;
            } else {
                node = stack1.pop();
                node = node.left;
            }
        }
        while (!stack2.isEmpty()) {
            TreeNode element = stack2.pop();
            System.out.println(element.val);
        }
    }
}
