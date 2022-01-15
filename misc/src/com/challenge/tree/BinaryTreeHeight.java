package com.challenge.tree;

import com.challenge.leetcode.topquestions.TreeNode;

import static java.lang.Math.max;

/**
 * @author Shakil Akhtar
 */
public class BinaryTreeHeight {

    int height(TreeNode node){
        if (node==null){
            return 0;
        }
        int leftHight=height(node.left);
        int rightHight = height(node.right);

        return 1+max(leftHight,rightHight);
    }
}
