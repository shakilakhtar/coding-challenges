package bst.medium;

import binarytrees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InorderSuccessorPredInBST {
    List<Integer> succPredBST(TreeNode root, int key) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);

        int predecessor = -1;
        int successor = -1;
        // Find the predecessor and successor in the sorted list
        for (int i = 0; i < list.size() ; i++) {
        // Update predecessor if the current value is less than the key
            if (list.get(i) < key){
                predecessor = list.get(i);
            }else {
                if (list.get(i) > key){
                    // Update successor if the current value is greater than the key
                    successor = list.get(i);
                    // No need to continue once successor is found
                    break;
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        result.add(predecessor);
        result.add(successor);
        return result;
    }

    private void inorderTraversal(TreeNode root, List<Integer> list){
        if (root == null){
            return;
        }
        inorderTraversal(root.left, list);
        list.add(root.data);
        inorderTraversal(root.right, list);
    }

    public static void main(String[] args) {

    }
}
