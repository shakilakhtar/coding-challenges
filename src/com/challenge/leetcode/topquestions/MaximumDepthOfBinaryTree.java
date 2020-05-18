package com.challenge.leetcode;
/**
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its depth = 3.
 *
 * @author Shakil Akhtar
 */
public class MaximumDepthOfBinaryTree {
    TreeNode root;

    public int maxDepth(TreeNode root) {

        if(root==null){
            return 0;
        }
        else {
            int lDepth =maxDepth(root.left);
            int rDepth=maxDepth(root.right);
            return Math.max(lDepth,rDepth)+1;
        }

    }
    public static void main(String[] args) {

        MaximumDepthOfBinaryTree tree = new MaximumDepthOfBinaryTree();

        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);

        System.out.println("Height of tree is : " +
                tree.maxDepth(tree.root));
    }
}
