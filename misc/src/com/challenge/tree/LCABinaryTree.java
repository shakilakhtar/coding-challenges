package com.challenge.tree;

import com.challenge.leetcode.topquestions.TreeNode;

/**
 * * Find lowest common ancestor in binary tree.
 * *
 * * Time complexity O(n)
 * * Space complexity O(h)
 *
 * @author shakil akhtar
 */
public class LCABinaryTree {

    TreeNode lca(TreeNode root, TreeNode n1, TreeNode n2) {

        if (root == null) {
            return null;
        }
        TreeNode left = lca(root.left, n1, n2);
        TreeNode right = lca(root.right, n1, n2);
        if (left != null && right != null) {
            return root;
        }

        if (left == null && right == null) {
            return null;
        }
        return left != null ? left : right;
    }

    public static void main(String[] args) {

    }
}
