package com.challenge.trees;

import com.challenge.leetcode.topquestions.TreeNode;

import static java.lang.Math.max;

/**
 * @author Shakil Akhtar
 */
public class BinaryTreeHeight {

    int hight(TreeNode node){
        if (node==null){
            return 0;
        }
        int leftHight=hight(node.left);
        int rightHight = hight(node.right);

        return 1+max(leftHight,rightHight);
    }
}
