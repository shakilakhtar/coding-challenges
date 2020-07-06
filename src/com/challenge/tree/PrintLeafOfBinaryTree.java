package com.challenge.tree;

import com.challenge.leetcode.topquestions.*;

public class PrintLeafOfBinaryTree {


    public static void printLeafOfBinaryTree(TreeNode root) {
        if (root == null) {
            return;
        } else if ((root.left == null) && (root.right == null)) {
            System.out.println(root.val);
        } else {
            printLeafOfBinaryTree(root.left);
            printLeafOfBinaryTree(root.right);
        }
    }
}
