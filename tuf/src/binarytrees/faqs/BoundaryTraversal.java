package binarytrees.faqs;

import binarytrees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BoundaryTraversal {
    public List<Integer> boundary(TreeNode root) {
        //should be traverse
        //left boundary
        //leaf nodes
        //right boundary
        List<Integer> res = new ArrayList<>();
       if (root == null){
           return res;
       }
       if (!isLeafNode(root)){
           res.add(root.data);
       }

       //go to left boundary
        addLeftBoundary(root,res);
       //go to leaves
        addLeaves(root,res);
        //go to right boundary
        addRightBoundary(root, res);

        return res;
    }

    private void addLeftBoundary(TreeNode root, List<Integer> res){
        TreeNode current = root.left;
        while (current!=null){
            //add to result if not leaf node
            if (!isLeafNode(current)){
                res.add(current.data);
            }
            if (current.left != null){
                current = current.left;
            }else {
                current = current.right;
            }
        }
    }

    private void addRightBoundary(TreeNode root, List<Integer> res){
        TreeNode current = root.right;
        ArrayList<Integer> tempList = new ArrayList<>();
        while (current!=null){
            //add to result if not leaf node
            if (!isLeafNode(current)){
                tempList.add(current.data);
            }
            if (current.right != null){
                current = current.right;
            }else {
                current = current.left;
            }
        }
        // because we took stack add from top to result
        for (int i = tempList.size() -1; i >=0 ; i++) {
                res.add(i);
        }
    }

    private void addLeaves(TreeNode root, List<Integer> res){
        if (isLeafNode(root)){
            res.add(root.data);
        }
        //if left
        if (root.left != null){
            addLeaves(root.left, res);
        }
        if (root.right != null){
            addLeaves(root.right, res);
        }
    }
    private boolean isLeafNode(TreeNode root){
        return root.left == null && root.right == null;
    }


    public static void main(String[] args) {

    }
}
