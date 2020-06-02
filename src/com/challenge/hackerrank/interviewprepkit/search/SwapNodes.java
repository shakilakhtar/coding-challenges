package com.challenge.hackerrank.interviewprepkit.search;

import java.util.*;

/**
 * A binary tree is a tree which is characterized by one of the following properties:
 * <p>
 * It can be empty (null).
 * It contains a root node only.
 * It contains a root node with a left subtree, a right subtree, or both. These subtrees are also binary trees.
 * In-order traversal is performed as
 * <p>
 * Traverse the left subtree.
 * Visit root.
 * Traverse the right subtree.
 * For this in-order traversal, start from the left child of the root node and keep exploring the left subtree until you reach a leaf. When you reach a leaf, back up to its parent, check for a right child and visit it if there is one. If there is not a child, you've explored its left and right subtrees fully. If there is a right child, traverse its left subtree then its right in the same manner. Keep doing this until you have traversed the entire tree. You will only store the values of a node as you visit when one of the following is true:
 * <p>
 * it is the first node visited, the first time visited
 * it is a leaf, should only be visited once
 * all of its subtrees have been explored, should only be visited once while this is true
 * it is the root of the tree, the first time visited
 * Swapping: Swapping subtrees of a node means that if initially node has left subtree L and right subtree R, then after swapping, the left subtree will be R and the right subtree, L.
 * <p>
 * For example, in the following tree, we swap children of node 1.
 * <p>
 * Depth
 * 1               1            [1]
 * / \             / \
 * 2   3     ->    3   2          [2]
 * \   \           \   \
 * 4   5           5   4        [3]
 * In-order traversal of left tree is 2 4 1 3 5 and of right tree is 3 5 1 2 4.
 * <p>
 * Swap operation:
 * <p>
 * We define depth of a node as follows:
 * <p>
 * The root node is at depth 1.
 * If the depth of the parent node is d, then the depth of current node will be d+1.
 * Given a tree and an integer, k, in one operation, we need to swap the subtrees of all the nodes at each depth h, where h ∈ [k, 2k, 3k,...]. In other words, if h is a multiple of k, swap the left and right subtrees of that level.
 * <p>
 * You are given a tree of n nodes where nodes are indexed from [1..n] and it is rooted at 1. You have to perform t swap operations on it, and after each swap operation print the in-order traversal of the current state of the tree.
 * <p>
 * Function Description
 * <p>
 * Complete the swapNodes function in the editor below. It should return a two-dimensional array where each element is an array of integers representing the node indices of an in-order traversal after a swap operation.
 * <p>
 * swapNodes has the following parameter(s):
 * - indexes: an array of integers representing index values of each , beginning with , the first element, as the root.
 * - queries: an array of integers, each representing a  value.
 * <p>
 * Input Format
 * The first line contains n, number of nodes in the tree.
 * <p>
 * Each of the next n lines contains two integers, a b, where a is the index of left child, and b is the index of right child of ith node.
 * <p>
 * Note: -1 is used to represent a null node.
 * <p>
 * The next line contains an integer, t, the size of .
 * Each of the next t lines contains an integer , each being a value .
 * <p>
 * Output Format
 * For each k, perform the swap operation and store the indices of your in-order traversal to your result array. After all swap operations have been performed, return your result array for printing.
 * <p>
 * Constraints
 * <p>
 * Either  or
 * Either  or
 * The index of a non-null child will always be greater than that of its parent.
 * Sample Input 0
 * <p>
 * 3
 * 2 3
 * -1 -1
 * -1 -1
 * 2
 * 1
 * 1
 * Sample Output 0
 * <p>
 * 3 1 2
 * 2 1 3
 * Explanation 0
 * <p>
 * As nodes 2 and 3 have no children, swapping will not have any effect on them. We only have to swap the child nodes of the root node.
 * <p>
 * 1   [s]       1    [s]       1
 * / \      ->   / \        ->  / \
 * 2   3 [s]     3   2  [s]     2   3
 * Note: [s] indicates that a swap operation is done at this depth.
 * <p>
 * Sample Input 1
 * <p>
 * 5
 * 2 3
 * -1 4
 * -1 5
 * -1 -1
 * -1 -1
 * 1
 * 2
 * Sample Output 1
 * <p>
 * 4 2 1 5 3
 * Explanation 1
 * <p>
 * Swapping child nodes of node 2 and 3 we get
 * <p>
 * 1                  1
 * / \                / \
 * 2   3   [s]  ->    2   3
 * \   \            /   /
 * 4   5          4   5
 * Sample Input 2
 * <p>
 * 11
 * 2 3
 * 4 -1
 * 5 -1
 * 6 -1
 * 7 8
 * -1 9
 * -1 -1
 * 10 11
 * -1 -1
 * -1 -1
 * -1 -1
 * 2
 * 2
 * 4
 * Sample Output 2
 * <p>
 * 2 9 6 4 1 3 7 5 11 8 10
 * 2 6 9 4 1 3 7 5 10 8 11
 * Explanation 2
 * <p>
 * Here we perform swap operations at the nodes whose depth is either 2 or 4 for  and then at nodes whose depth is 4 for .
 * <p>
 * 1                     1                          1
 * / \                   / \                        / \
 * /   \                 /   \                      /   \
 * 2     3    [s]        2     3                    2     3
 * /      /                \     \                    \     \
 * /      /                  \     \                    \     \
 * 4      5          ->        4     5          ->        4     5
 * /      / \                  /     / \                  /     / \
 * /      /   \                /     /   \                /     /   \
 * 6      7     8   [s]        6     7     8   [s]        6     7     8
 * \          / \            /           / \              \         / \
 * \        /   \          /           /   \              \       /   \
 * 9      10   11        9           11   10              9     10   11
 */
public class SwapNodes {

    private static class Node {
        int index;
        Node left;
        Node right;
    }

    private static Node createTree(int[][] nodes, Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        for (int i = 0; i < nodes.length; i++) {
            Node cur = queue.poll();
            int left = nodes[i][0];
            int right = nodes[i][1];

            if (left != -1) {
                Node l = new Node();
                l.index = left;
                cur.left = l;
                queue.offer(l);
            }
            if (right != -1) {
                Node r = new Node();
                r.index = right;
                cur.right = r;
                queue.offer(r);
            }
        }
        return root;
    }

    private static void swap(Node root, int k, int level) {
        if (root == null)
            return;
        if (level == 1) {
            Node temp = root.right;
            root.right = root.left;
            root.left = temp;
            level = k;
        } else {
            level--;
        }
        swap(root.left, k, level);
        swap(root.right, k, level);
    }

    private static void swap(Node root, int k) {
        swap(root, k, k);
    }

    private static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.index + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Node root = new Node();
        root.index = 1;
        int[][] nodes = new int[n][2];
        for (int i = 0; i < n; i++) {
            nodes[i][0] = scan.nextInt();
            nodes[i][1] = scan.nextInt();
        }
        root = createTree(nodes, root);
        int t = scan.nextInt();
        for (int i = 0; i < t; i++) {
            int k = scan.nextInt();
            swap(root, k);
            inorder(root);
            System.out.println();
        }
        scan.close();

    }

}

