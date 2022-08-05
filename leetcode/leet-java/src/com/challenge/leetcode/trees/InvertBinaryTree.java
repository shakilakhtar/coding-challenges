package com.challenge.leetcode.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 226. Invert Binary Tree
 *
 * Given the root of a binary tree, invert the tree, and return its root.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [4,2,7,1,3,6,9]
 * Output: [4,7,2,9,6,3,1]
 * Example 2:
 *
 *
 * Input: root = [2,1,3]
 * Output: [2,3,1]
 * Example 3:
 *
 * Input: root = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 * Accepted
 * 1,143,949
 * Submissions
 * 1,579,632
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root ==null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode currentNode = queue.poll();
            TreeNode temp = currentNode.left;
            currentNode.left= currentNode.right;
            currentNode.right = temp;
            if (currentNode.left!=null){
                queue.add(currentNode.left);
            }
            if (currentNode.right!=null){
                queue.add(currentNode.right);
            }
        }
        return root;
    }
}
