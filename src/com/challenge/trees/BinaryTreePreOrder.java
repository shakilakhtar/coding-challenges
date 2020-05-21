package com.challenge.trees;

import com.challenge.leetcode.topquestions.TreeNode;

/**
 * @author Shakil Akhtar
 */
public class BinaryTreePreOrder {

    public void inOrder(TreeNode node){
        if(node!=null){
            System.out.println(node.val);
            inOrder(node.left);
            inOrder(node.right);
        }
    }
}
