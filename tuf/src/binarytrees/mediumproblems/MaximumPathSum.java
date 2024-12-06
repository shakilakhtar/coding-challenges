package binarytrees.mediumproblems;

import binarytrees.TreeNode;

public class MaximumPathSum {

    public int maxPathSum(TreeNode root) {
        int[] max = {Integer.MIN_VALUE};
        findMaxPath(root, max);
        return max[0];
    }

    private int findMaxPath(TreeNode node, int[] max){
        if (node == null){
            return 0;
        }
        int leftSum = Math.max(0, findMaxPath(node.left, max));
        int rightSum = Math.max(0, findMaxPath(node.right, max));
        //backtrack store current max
        max[0] = Math.max(max[0],leftSum + rightSum + node.data);

        return Math.max(leftSum, rightSum) + node.data;
    }
    public static void main(String[] args) {

    }
}
