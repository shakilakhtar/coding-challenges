package com.challenge.tree;

import com.challenge.leetcode.topquestions.TreeNode;

/**
 * @author Shakil Akhtar
 */
public class BinaryTreeInOrder {

    public void inOrder(TreeNode node){
        if (node!=null){
            inOrder(node.left);
            System.out.println(node.val);
            inOrder(node.right);
        }
    }
}
