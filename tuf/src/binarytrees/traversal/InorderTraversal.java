package binarytrees.traversal;

import binarytrees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
    public List<Integer> inorder(TreeNode root) {
        List<Integer> inorder =  new ArrayList<>();
        recFunc(root, inorder);
        return inorder;
    }

    private void recFunc(TreeNode node, List<Integer> result){
        if (node == null){
            return;
        }
        recFunc(node.left, result);
        result.add(node.data);
        recFunc(node.right, result);
    }

    public static void main(String[] args) {

    }
}
