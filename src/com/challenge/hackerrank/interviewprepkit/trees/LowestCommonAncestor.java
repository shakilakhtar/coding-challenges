package com.challenge.hackerrank.interviewprepkit.trees;

/**
 * You are given pointer to the root of the binary search tree and two values  and . You need to return the lowest common ancestor (LCA) of  and  in the binary search tree.
 * <p>
 * image
 * In the diagram above, the lowest common ancestor of the nodes  and  is the node . Node  is the lowest node which has nodes  and  as descendants.
 * <p>
 * Function Description
 * <p>
 * Complete the function lca in the editor below. It should return a pointer to the lowest common ancestor node of the two values given.
 * <p>
 * lca has the following parameters:
 * - root: a pointer to the root node of a binary search tree
 * - v1: a node.data value
 * - v2: a node.data value
 * <p>
 * Input Format
 * <p>
 * The first line contains an integer, , the number of nodes in the tree.
 * The second line contains  space-separated integers representing  values.
 * The third line contains two space-separated integers,  and .
 * <p>
 * To use the test data, you will have to create the binary search tree yourself. Here on the platform, the tree will be created for you.
 * <p>
 * Constraints
 * <p>
 * <p>
 * <p>
 * <p>
 * The tree will contain nodes with data equal to  and .
 * <p>
 * Output Format
 * <p>
 * Return the a pointer to the node that is the lowest common ancestor of  and .
 * <p>
 * Sample Input
 * <p>
 * 6
 * 4 2 3 1 7 6
 * 1 7
 * image
 * and .
 * <p>
 * Sample Output
 * <p>
 * [reference to node 4]
 * <p>
 * Explanation
 * <p>
 * LCA of  and  is , the root in this case.
 * Return a pointer to the node.
 */
public class LowestCommonAncestor {

    public static Node lca(Node root, int v1, int v2) {
        //Decide if you have to call rekursively
        //Samller than both
        if (root.data < v1 && root.data < v2) {
            return lca(root.right, v1, v2);
        }
        //Bigger than both
        if (root.data > v1 && root.data > v2) {
            return lca(root.left, v1, v2);
        }

        //Else solution already found
        return root;
    }

    public static void main(String[] args) {

    }
}

//class Node {
//    int data;
//    Node left;
//    Node right;
//}
