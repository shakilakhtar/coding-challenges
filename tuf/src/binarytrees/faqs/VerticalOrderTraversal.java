package binarytrees.faqs;

import binarytrees.TreeNode;

import java.util.*;

public class VerticalOrderTraversal {
    static class TreeNodeDistance{
        public TreeNode node;
        public int x;
        public int y;

        public TreeNodeDistance(TreeNode node, int x, int y){
            this.node = node;
            this.x = x;
            this.y = y;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        //create a map to store nodes at vertical distance
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> distanceMap = new TreeMap<>();

        //Level order traversal
        Queue<TreeNodeDistance> queue = new LinkedList<>();
        queue.add(new TreeNodeDistance(root, 0,0));

        while (!queue.isEmpty()){
            TreeNodeDistance nodeDistance =  queue.poll();
            TreeNode node = nodeDistance.node;
            int x = nodeDistance.x;
            int y = nodeDistance.y;
            distanceMap.putIfAbsent(x,new TreeMap<>());
            distanceMap.get(x).putIfAbsent(y, new PriorityQueue<>());
            distanceMap.get(x).get(y).add(node.data);

            // Add the left child with updated coordinates to the queue
            if (node.left != null){
                queue.add(new TreeNodeDistance(node.left,x - 1, y + 1));
            }
            if (node.right != null){
                queue.add(new TreeNodeDistance(node.right, x + 1, y + 1));
            }
        }
        // Prepare the result by sorting keys and compiling nodes
        for (TreeMap<Integer, PriorityQueue<Integer>> yMap:distanceMap.values()) {
            List<Integer> column = new ArrayList<>();
            for (PriorityQueue<Integer> nodes : yMap.values()) {
                while (!nodes.isEmpty()) {
                    column.add(nodes.poll());
                }
            }
            result.add(column);
            
        }

       return result;
    }
    public static void main(String[] args) {

    }
}
