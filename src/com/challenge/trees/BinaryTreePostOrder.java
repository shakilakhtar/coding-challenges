package com.challenge.trees;

import com.challenge.leetcode.topquestions.TreeNode;

/**
 * @author Shakil Akhtar
 */
public class BinaryTreePostOrder {

    public void postOrder(TreeNode node){
        if (node!=null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.val);
        }
    }
}
