package com.challenge.hackerrank.interviewprepkit.trees;

/**
 * The height of a binary tree is the number of edges between the tree's root and its furthest leaf. For example, the following binary tree is of height :
 * <p>
 * image
 * Function Description
 * <p>
 * Complete the getHeight or height function in the editor. It must return the height of a binary tree as an integer.
 * <p>
 * getHeight or height has the following parameter(s):
 * <p>
 * root: a reference to the root of a binary tree.
 * Note -The Height of binary tree with single node is taken as zero.
 * <p>
 * Input Format
 * <p>
 * The first line contains an integer , the number of nodes in the tree.
 * Next line contains  space separated integer where th integer denotes node[i].data.
 * <p>
 * Note: Node values are inserted into a binary search tree before a reference to the tree's root node is passed to your function. In a binary search tree, all nodes on the left branch of a node are less than the node value. All values on the right branch are greater than the node value.
 * <p>
 * Constraints
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Your function should return a single integer denoting the height of the binary tree.
 * <p>
 * Sample Input
 * <p>
 * image
 * <p>
 * Sample Output
 * <p>
 * 3
 * Explanation
 * <p>
 * The longest root-to-leaf path is shown below:
 * <p>
 * image
 * <p>
 * There are  nodes in this path that are connected by  edges, meaning our binary tree's .
 */
public class HeightOfABinaryTree {

    public static int height(Node root) {

        if (root == null) {
            return -1;
        }
        int left = height(root.left);
        int right = height(root.right);
        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {

    }
}
