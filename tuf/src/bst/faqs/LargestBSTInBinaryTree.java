package bst.faqs;

import binarytrees.TreeNode;

public class LargestBSTInBinaryTree {
    // Helper class to store information about a subtree
    class BSTInfo {
        int size;
        boolean isBST;
        int min;
        int max;

        public BSTInfo(int size, boolean isBST, int min, int max){
            this.size = size;
            this.isBST = isBST;
            this.min = min;
            this.max =  max;
        }
    }

    private BSTInfo isBSTAndSize(TreeNode node, int minValue , int maxValue){
        // Base case: if node is null, it is a valid BST of size 0.
        if (node == null){
            return new BSTInfo(0, true, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        // Recursively check the left and right subtrees.
        BSTInfo left =  isBSTAndSize(node.left, minValue, node.data);
        BSTInfo right =  isBSTAndSize(node.right, node.data, maxValue);

        // Check if the current node is a valid BST node.
        if (left.isBST && right.isBST && left.max < node.data && node.data < right.min) {
            // Current subtree is a valid BST, calculate its size.
            int size = left.size + right.size + 1;
            // Return size, isBST, min value, and max value for the current subtree.
            return new BSTInfo(size, true, Math.min(node.data, left.min), Math.max(node.data, right.max));
        } else {
            // Current subtree is not a valid BST, return the size of the largest valid BST found so far.
            return new BSTInfo(Math.max(left.size, right.size), false, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
    }

    public int largestBST(TreeNode root) {
        // Initialize the function to call
        return isBSTAndSize(root, Integer.MIN_VALUE, Integer.MAX_VALUE).size;
    }
    public static void main(String[] args) {

    }
}
