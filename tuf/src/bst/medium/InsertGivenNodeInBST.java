package bst.medium;

import binarytrees.TreeNode;

public class InsertGivenNodeInBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        TreeNode current  = root;
        while (true){
            if (current.data <= val){
                if (current.right != null){
                    current =  current.right;
                }else {
                    current.right =  new TreeNode(val);
                    break;
                }
            }else {
                if (current.left != null){
                    current = current.left;
                }else {
                    current.left = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }
    public static void main(String[] args) {

    }
}
