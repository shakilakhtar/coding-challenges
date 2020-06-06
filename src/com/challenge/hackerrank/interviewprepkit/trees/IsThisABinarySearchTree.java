package com.challenge.hackerrank.interviewprepkit.trees;

/**
 * For the purposes of this challenge, we define a binary search tree to be a binary tree with the following properties:
 * <p>
 * The  value of every node in a node's left subtree is less than the data value of that node.
 * The  value of every node in a node's right subtree is greater than the data value of that node.
 * The  value of every node is distinct.
 * For example, the image on the left below is a valid BST. The one on the right fails on several counts:
 * - All of the numbers on the right branch from the root are not larger than the root.
 * - All of the numbers on the right branch from node 5 are not larger than 5.
 * - All of the numbers on the left branch from node 5 are not smaller than 5.
 * - The data value 1 is repeated.
 * <p>
 * <p>
 * <p>
 * Given the root node of a binary tree, determine if it is a binary search tree.
 * <p>
 * Function Description
 * <p>
 * Complete the function checkBST in the editor below. It must return a boolean denoting whether or not the binary tree is a binary search tree.
 * <p>
 * checkBST has the following parameter(s):
 * <p>
 * root: a reference to the root node of a tree to test
 * Input Format
 * <p>
 * You are not responsible for reading any input from stdin. Hidden code stubs will assemble a binary tree and pass its root node to your function as an argument.
 * <p>
 * Constraints
 * <p>
 * Output Format
 * <p>
 * Your function must return a boolean true if the tree is a binary search tree. Otherwise, it must return false.
 * <p>
 * Sample Input
 * <p>
 * image
 * <p>
 * Sample Output
 * <p>
 * Yes
 * Explanation
 * <p>
 * The tree in the diagram satisfies the ordering property for a Binary Search Tree, so we print Yes.
 */
public class IsThisABinarySearchTree {
    static class Node {
        int data;
        Node left;
        Node right;
    }


    boolean checkBST(Node root) {
        return isBST(root, Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    public boolean isBST(Node root, int min, int max) {
        if (root == null) {
            return false;
        }
        if (root.left.data >= root.data && root.right.data <= root.data) {
            return false;
        }

        return checkBST(root.left) && checkBST(root.right);
    }

    public static void main(String[] args) {

    }
}

