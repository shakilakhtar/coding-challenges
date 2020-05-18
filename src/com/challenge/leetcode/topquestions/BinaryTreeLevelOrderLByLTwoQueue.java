package com.challenge.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * @author Shakil Akhtar
 */
public class BinaryTreeLevelOrderLByLTwoQueue {
    TreeNode root;
    /**
     * Take two queues add root to the queue1, add it's left and right child in the queue2.
     * Take element out from queue1 FIFO till then empty add it's left and right child in the queue2 do this
     * for all.
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderLineByLine(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root==null){
            return result;
        }
        Queue<TreeNode> q1= new LinkedList<TreeNode>();
        Queue<TreeNode> q2= new LinkedList<TreeNode>();
        q1.add(root);
        while (!q1.isEmpty()|| !q2.isEmpty()){

            List<Integer> levelList = new ArrayList<>();
            while (!q1.isEmpty()) {
                root = q1.poll();
                System.out.print(root.val + " ");
                levelList.add(root.val);
                if (root.left != null) {
                    //add to q2
                    q2.add(root.left);
                }
                if (root.right != null) {
                    //add right to q2
                    q2.add(root.right);
                }
            }
            System.out.println();
            if(!levelList.isEmpty()) {
                result.add(levelList);
            }
            List<Integer> levelList1 = new ArrayList<>();
            while (!q2.isEmpty()){
            root=q2.poll();
            System.out.print(root.val+" ");
            levelList1.add(root.val);
            if (root.left!=null){
                //add to q1
                q1.add(root.left);
            }
            if(root.right!=null){
                //add right to q1
                q1.add(root.right);
            }
         }
        //print new line
            System.out.println();
            if(!levelList1.isEmpty()) {
                result.add(levelList1);
            }
        }
      return result;
    }
    public static void main(String[] args) {
        BinaryTreeLevelOrderLByLTwoQueue tree = new BinaryTreeLevelOrderLByLTwoQueue();

        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.levelOrderLineByLine(tree.root);
    }
}
