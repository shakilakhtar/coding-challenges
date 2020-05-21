package com.challenge.trees;

import com.challenge.leetcode.topquestions.TreeNode;

/**
 * @author Shakil Akhtar
 */
public class BinaryTreeSize {

    int size(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = size(node.left);
        int right = size(node.right);
        return left + right + 1;
    }
}
