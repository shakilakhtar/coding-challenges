package bst.medium;

import binarytrees.TreeNode;

public class LCAInBST {
    public TreeNode lca(TreeNode root, int p, int q) {
        if (root == null){
            return null;
        }
        int current = root.data;;
        if (current < p && current < q){
            return lca(root.right, p, q);
        }
        if (current > p && current > q){
            return lca(root.left, p, q);
        }
        return root;
    }
    public static void main(String[] args) {

    }
}
