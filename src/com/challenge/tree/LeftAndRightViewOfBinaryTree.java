package com.challenge.tree;

import com.challenge.leetcode.topquestions.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LeftAndRightViewOfBinaryTree {
    private TreeNode root;

    /**
     * Binary Tree Left View
     *
     * @param root
     */
    public void leftViewBinaryTree(TreeNode root) {
        if (root == null) {
            return;
        }
        int count = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        count++;
        while (!queue.isEmpty()) {
            root = queue.poll();
            count--;
            if (count == queue.size()) {
                System.out.println(root.val);
            }
            if (root.left != null) {
                queue.add(root.left);
                count++;
            }
            if (root.right != null) {
                queue.add(root.right);
                count++;
            }
        }

    }

    /**
     * Binary Tree right view
     *
     * @param root
     */
    public void rightViewBinaryTree(TreeNode root) {
        if (root == null) {
            return;
        }
        int count = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        count++;
        while (!queue.isEmpty()) {
            root = queue.poll();
            count--;
            if (count == 0) {
                System.out.println(root.val);
            }
            if (root.left != null) {
                queue.add(root.left);
                count++;
            }
            if (root.right != null) {
                queue.add(root.right);
                count++;
            }
        }
    }


    public static void main(String[] args) {

        LeftAndRightViewOfBinaryTree tree = new LeftAndRightViewOfBinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.rightViewBinaryTree(tree.root);
    }
}
