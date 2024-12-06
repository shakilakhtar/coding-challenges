package bst.medium;

import binarytrees.TreeNode;

public class DeleteNodeInBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null){
            return null;
        }
        if (root.data == key){
            return rearrangeAfterDelete(root);
        }
        TreeNode dummy =  root;
        while (root != null){
            if (root.data > key){
                if (root.left != null && root.left.data == key){
                    root.left = rearrangeAfterDelete(root.left);
                    break;
                }else {
                    root = root.left;
                }
            }else {
                if (root.right != null && root.right.data == key){
                    root.right = rearrangeAfterDelete(root.right);
                    break;
                }else {
                    root = root.right;
                }
            }
        }
        return dummy;
    }


    private TreeNode rearrangeAfterDelete(TreeNode root){
        if (root.left ==  null){
            return root.right;
        }
        else if (root.right == null){
            return root.left;
        }else {
            TreeNode rightChild =  root.right;
            //find last right of the left child subtree
            TreeNode lastRightNode = findLastRight(root.left);
            //assign last right to right child
            lastRightNode.right = rightChild;
            return root.left;
        }

    }
    private TreeNode findLastRight(TreeNode node){
        if (node.right == null){
            return node;
        }
        return findLastRight(node.right);
    }
    public static void main(String[] args) {

    }
}
