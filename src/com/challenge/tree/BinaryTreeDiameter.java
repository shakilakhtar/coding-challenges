package com.challenge.tree;

import com.challenge.leetcode.topquestions.TreeNode;

import static java.lang.Math.max;

/**
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 * <p>
 * Example:
 * Given a binary tree
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 * <p>
 * Note: The length of path between two nodes is represented by the number of edges between them.
 *
 * @author Shakil Akhtar
 */
public class BinaryTreeDiameter {

    int diameter(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int leftDiameter = diameter(root.left);
        int rightDiameter = diameter(root.right);

        int diameter = max(leftHeight + rightHeight, max(leftDiameter, rightDiameter));

        return diameter;
    }

    int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHight = height(root.left);
        int rightHight = height(root.right);

        return 1 + max(leftHight, rightHight);
    }

    public static void main(String[] args) {

    }
}
