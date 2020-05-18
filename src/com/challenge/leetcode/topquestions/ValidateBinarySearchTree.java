package com.challenge.leetcode;
/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * Example 1:
 *
 *     2
 *    / \
 *   1   3
 *
 * Input: [2,1,3]
 * Output: true
 * Example 2:
 *
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 *
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 *
 * @author Shakil Akhtar
 */
public class ValidateBinarySearchTree {
    TreeNode root;

    public boolean isValidBST(TreeNode root) {
        return isBST(root,null,null);
    }

    public boolean isBST(TreeNode root,Integer min,Integer max){
        if(root==null){
            return true;
        }
        if(min!=null && root.val<=min ){
            return false;
        }
        if(max!=null && root.val>=max){
            return false;
        }
        return isBST(root.left,min,root.val) && isBST(root.right,root.val,max);
    }

    public static void main(String[] args) {
        ValidateBinarySearchTree tree = new ValidateBinarySearchTree();

        tree.root = new TreeNode(1);
//        tree.root.left = new TreeNode(1);
        tree.root.right = new TreeNode(1);
//        tree.root.left.left = new TreeNode(0);
//        tree.root.left.right = new TreeNode(4);
//        tree.root.right.left = new TreeNode(3);
//        tree.root.right.right = new TreeNode(6);


        System.out.println(tree.isValidBST(tree.root));
    }
}
