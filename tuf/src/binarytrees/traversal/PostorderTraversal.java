package binarytrees.traversal;

import binarytrees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PostorderTraversal {

    public List<Integer> postorder(TreeNode root) {
        List<Integer> postOrder =  new ArrayList<>();
        recFunc(root, postOrder);
        return postOrder;
    }

    private void recFunc(TreeNode node, List<Integer> result){
        if (node == null){
            return;
        }
        recFunc(node.left,result);
        recFunc(node.right, result);
        result.add(node.data);
    }

    public static void main(String[] args) {

    }
}
