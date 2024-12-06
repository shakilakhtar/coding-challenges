package binarytrees.mediumproblems;

import binarytrees.TreeNode;

public class CheckTwoTreesIdentical {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null){
            return true;
        }
        return (p.data == q.data) && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
    public static void main(String[] args) {

    }
}
