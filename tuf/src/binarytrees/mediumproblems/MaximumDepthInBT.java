package binarytrees.mediumproblems;

import binarytrees.TreeNode;

public class MaximumDepthInBT {
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return 1 + Math.max(left,right);
    }
    public static void main(String[] args) {

    }
}
