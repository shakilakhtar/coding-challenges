package binarytrees.faqs;

import binarytrees.TreeNode;

import java.util.*;

public class MinTimeToBurnBTFromANode {
    public int timeToBurnTree(TreeNode root, int start) {
        Map<TreeNode, TreeNode> map =  new HashMap<>();
        TreeNode target = bfsToMapParents(root,map,start);
        int maxDistance = findMaxDistance(map,target);
        return maxDistance;
    }

    //first map all parent pointers then perform BFS
    private TreeNode bfsToMapParents(TreeNode root, Map<TreeNode, TreeNode> map, int start){
        //take a queue
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //the new root from where we are burning the tree
        TreeNode result = new TreeNode(-1);
         while (!queue.isEmpty()){
             TreeNode node = queue.poll();
             //check is this is the start node
             if (node.data == start){
                 result = node;
             }
             //map the left child of the parent
             if (node.left != null){
                 map.put(node.left, node);
                 queue.offer(node.left);
             }
             if (node.right != null){
                 map.put(node.right, node);
                 queue.offer(node.right);
             }
         }
         return result;
    }

    // Method to find the maximum distance to burn the tree
    private int findMaxDistance(Map<TreeNode, TreeNode> map, TreeNode target){
        //queue for BFS to find max distance
        Queue<TreeNode> queue =  new LinkedList<>();
        queue.offer(target);
        //Map to check visited nodes
        Map<TreeNode, Integer> visited =  new HashMap<>();
        visited.put(target,1);
        int maxDist = 0;
        while (!queue.isEmpty()){
            int queueSize = queue.size();
            int flag = 0;
            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.poll();

                //check left child
                if (node.left != null && visited.get(node.left) == null){
                    flag = 1;
                    visited.put(node.left, 1);
                    queue.offer(node.left);
                }
                if (node.right != null && visited.get(node.right) == null){
                    flag = 1;
                    visited.put(node.right, 1);
                    queue.offer(node.right);
                }
                //check parent node
                if (map.get(node) != null && visited.get(map.get(node)) == null){
                    flag = 1;
                    visited.put(map.get(node) , 1);
                    queue.offer(map.get(node));
                }
            }
            // Increment max distance if any node was burned
            if (flag == 1){
                maxDist++;
            }
        }
        return maxDist;
    }
    public static void main(String[] args) {

    }
}
