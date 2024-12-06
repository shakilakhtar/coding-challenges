package bst.medium;

import binarytrees.TreeNode;

public class ConstructBSTFromPreorder {
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, Integer.MAX_VALUE, new int[]{0});
    }
    private TreeNode bstFromPreorder(int[] a, int bound, int[] idx){
        if (idx[0]== a.length || a[idx[0]] > bound){
            return null;
        }
        TreeNode root = new TreeNode(a[idx[0]++]);
        root.left =  bstFromPreorder(a, root.data,idx);
        root.right = bstFromPreorder(a, bound, idx);
        return root;
    }
    public static void main(String[] args) {

    }
}
