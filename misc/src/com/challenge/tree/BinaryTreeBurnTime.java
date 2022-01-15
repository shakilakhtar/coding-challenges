package com.challenge.tree;

import com.challenge.leetcode.topquestions.TreeNode;

/**
 * We are given a binary tree and a leaf node, we need to find time to burn the Binary Tree if we burn the given leaf at 0-th second.
 */
public class BinaryTreeBurnTime {

    int res = 0;

    static class Distance {
        int val;

        Distance(int d) {
            val = d;
        }
    }

    int burnTime(TreeNode root, int leaf, Distance dist) {
        if (root == null) {
            return 0;
        }
        if (root.val == leaf) {

            dist.val = 0;
            return 1;
        }

        Distance ldist = new Distance(-1);
        Distance rdist = new Distance(-1);
        int lhight = burnTime(root.left, leaf, ldist);
        int rhight = burnTime(root.right, leaf, rdist);
        if (ldist.val != -1) {

            dist.val = ldist.val + 1;
            res = Math.max(res, dist.val + rhight);
        } else if (rdist.val != -1) {
            dist.val = rdist.val + 1;
            res = Math.max(res, dist.val + lhight);
        }

        return Math.max(lhight, rhight) + 1;
    }


    public static void main(String[] args) {

    }
}
