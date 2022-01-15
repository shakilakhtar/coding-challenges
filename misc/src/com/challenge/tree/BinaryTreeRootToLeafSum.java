package com.challenge.tree;

import com.challenge.leetcode.topquestions.TreeNode;

import java.util.List;

/**
 * @author Shakil Akhtar
 */
public class BinaryTreeRootToLeafSum {

    boolean rootToLeafSum(TreeNode root, int sum, List<Integer> result) {
        if (root == null) {
            return false;
        }
        //Leaf Node check
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                result.add(root.val);
                return true;
            }

        }
        if (rootToLeafSum(root.left, sum - root.val, result)) {
            result.add(root.val);
            return true;
        }

        if (rootToLeafSum(root.right, sum - root.val, result)) {
            result.add(root.val);
            return true;

        }
        return false;
    }
}
