package com.challenge.tree;

import com.challenge.leetcode.topquestions.*;

import java.util.*;

/**
 * Take two stack and do the insertion as level order in one with left child first and other right child first
 *
 * @author shakilakhtar
 */
public class SpiralOrderTraversalBinaryTree {


    public void spiralLevelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);

        while (!stack1.isEmpty() || !stack2.isEmpty()) {

            while (!stack1.isEmpty()) {

                TreeNode node = stack1.pop();
                System.out.println(node.val);
                if (node.left != null) {
                    stack2.push(node.left);
                }
                if (node.right != null) {
                    stack2.push(node.right);
                }
            }
            while (!stack2.isEmpty()) {
                TreeNode node = stack2.pop();
                System.out.println(node.val);
                if (node.right != null) {
                    stack1.push(node.right);
                }
                if (node.left != null) {
                    stack1.push(node.left);
                }
            }
        }
    }
}
