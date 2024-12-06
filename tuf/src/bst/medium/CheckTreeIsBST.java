package bst.medium;

import binarytrees.TreeNode;

public class CheckTreeIsBST {
    public boolean isBST(TreeNode root) {
         return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long minVal, long maxVal){
        if (root == null){
            return true;
        }
        //check if root values are within range {-infinity, to + infinity}
        if (root.data <= minVal || root.data >= maxVal){
            return false;
        }
         return isValidBST(root.left,minVal, root.data)
                 && isValidBST(root.right, root.data, maxVal);
    }
    public static void main(String[] args) {

    }
}
