package com.challenge.tree;

import com.challenge.leetcode.topquestions.*;

public class PrintLeftNodesExceptLeafNode {

    public static void printLeftNodesExceptLeafNode(TreeNode root) {
        if (root == null) {
            return;
        } else if ((root.left == null) && (root.right == null)) {
            return;
        } else {
            System.out.println(root.val);
            printLeftNodesExceptLeafNode(root.left);
        }
    }
}
