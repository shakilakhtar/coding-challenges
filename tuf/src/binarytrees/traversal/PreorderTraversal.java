package binarytrees.traversal;

import binarytrees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {

    public List<Integer> preorder(TreeNode root) {
        List<Integer> traversal =  new ArrayList<>();
        recFunc(root, traversal);
       return traversal;
    }

    private void recFunc(TreeNode node, List<Integer> result){
        if (node == null){
            return;
        }
        //preorder root, left, right
        result.add(node.data);
        //recursion
        recFunc(node.left, result);
        recFunc(node.right, result);
    }
    public static void main(String[] args) {

    }
}
