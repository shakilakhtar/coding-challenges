package binarytrees.traversal;

import binarytrees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> traversals = new ArrayList<>();
        if (root == null){
            return traversals;
        }
        Queue<TreeNode> queue =  new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            int levelSize  =  queue.size();
            List<Integer> level =  new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                //get the node from queue
                TreeNode node = queue.poll();
                //add current node in traversal
                level.add(node.data);

                //check left and right node
                if (node.left != null){
                    //add to queue
                    queue.add(node.left);
                }
                if (node.right != null){
                    //add right node
                    queue.add(node.right);
                }
            }
            //add leve traversal to results
            traversals.add(level);
        }
        return traversals;
    }
    public static void main(String[] args) {

    }
}
