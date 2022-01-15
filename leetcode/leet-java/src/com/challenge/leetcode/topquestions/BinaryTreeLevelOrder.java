package com.challenge.leetcode.topquestions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Shakil Akhtar
 */
public class BinaryTreeLevelOrder {
    TreeNode root;
    /**
     * Take a queue add root to the queue, add it's left and right child in the queue.
     * Take element out from queue FIFO add it's left and right child in the queue do this
     * for all.
     * @param root
     * @return
     */
    public void levelOrder(TreeNode root){
        if (root==null){
            return;
        }
        Queue<TreeNode> queue= new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()){
            root=queue.poll();
            System.out.print(root.val+" ");
            if (root.left!=null){
                //add to queue
                queue.add(root.left);
            }
            if(root.right!=null){
                //add right to queue
                queue.add(root.right);
            }
        }
    }

    public static void main(String[] args) {

        BinaryTreeLevelOrder tree = new BinaryTreeLevelOrder();

        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.levelOrder(tree.root);
    }
}
