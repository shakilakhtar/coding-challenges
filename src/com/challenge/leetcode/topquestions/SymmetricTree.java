package com.challenge.leetcode;
/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 *
 * But the following [1,2,2,null,3,null,3] is not:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 *
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 *
 * @author Shakil Akhtar
 */
public class SymmetricTree {
    TreeNode root;
    public static boolean isSymmetric(TreeNode root) {
      return isMirror(root,root);
    }

    public static boolean isMirror(TreeNode node1,TreeNode node2){

        if (node1==null && node2==null){
            return true;
        }
        if (node1==null || node2==null){
            return false;
        }

        if(node1.val==node2.val){
          if(isMirror(node1.left,node2.right)&&isMirror(node1.right,node2.left)){

              return true;
          }

        }
        return false;
    }

    public static void main(String[] args) {
        SymmetricTree tree = new SymmetricTree();

        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(2);
        tree.root.left.left = new TreeNode(3);
        tree.root.left.right = new TreeNode(4);
        tree.root.right.left = new TreeNode(4);
        tree.root.right.right = new TreeNode(3);


        System.out.println(tree.isSymmetric(tree.root));
    }
}
