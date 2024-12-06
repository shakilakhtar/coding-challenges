package binarytrees.mediumproblems;

import binarytrees.TreeNode;

public class CheckSymmetricalBTs {
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }

        return isSymmetricalHelper(root.left, root.right);
    }

    private boolean isSymmetricalHelper(TreeNode left, TreeNode right){
        if (left == null || right == null){
            return (left == right);
        }
        if (left.data != right.data){
            return false;
        }
        return isSymmetricalHelper(left.left, right.right)
                && isSymmetricalHelper(left.right, right.left);
    }
    public static void main(String[] args) {

    }
}
