package com.challenge.tree;

import com.challenge.leetcode.topquestions.*;

public class PrintRightNodeExceptLeaf {

    public static void printRightNodeExceptLeaf(TreeNode root) {
        if (root == null) {
            return;
        } else if ((root.left == null) && (root.right == null)) {
            return;
        } else {
            printRightNodeExceptLeaf(root.right);
            System.out.println(root.val);
        }
    }
}
