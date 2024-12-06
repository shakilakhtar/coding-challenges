package bst.faqs;

import binarytrees.TreeNode;

public class CorrectBSTWithTwoNodesSwapped {
    TreeNode first;
    TreeNode previous;
    TreeNode middle;
    TreeNode last;

    void recoverTree(TreeNode root) {
        first = middle = last =null;
        previous = new TreeNode(Integer.MIN_VALUE);
        inorder(root);

        if (first != null && last != null){
            int temp = first.data;
            first.data = last.data;
            last.data = temp;
        } else if (first != null && middle != null) {
            int temp = first.data;;
            first.data = middle.data;
            middle.data = temp;
        }
    }

    private void inorder(TreeNode root){
        if (root == null){
            return;
        }
        inorder(root.left);
        if (previous != null && (root.data < previous.data)){
            //it means its faulty as BST inorder start with sorted traversal
            //if first violation
            //mark these two nodes as first and middle
            if (first == null){
                first =  previous;
                middle = root;
            }else {
                //if the second violation. mark this node as last
                last = root;
            }
        }
        previous = root;
        inorder(root.right);
    }
    public static void main(String[] args) {

    }
}
