package binarytrees.faqs;

import binarytrees.Pair;
import binarytrees.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class TopViewOfBT {
    public List<Integer> topView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return null;
        }
        // Map to store the top view nodes based on their vertical positions
        Map<Integer, Integer> map = new TreeMap<>();
        //draw an axis line from root as zero distance take left node
        // as negative axis like -1,-2 right as +1, +2 as per their distance from this axis
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()){
            Pair<TreeNode, Integer> p = queue.poll();
            TreeNode node = p.getKey();
            int line =  p.getValue();

            if (!map.containsKey(node)){
                map.put(line, node.data);
            }

            if (node.left != null){
                // left side is negative add -1
                queue.add(new Pair<>(node.left, line - 1));
            }
            if (node.right != null){
                //right side is positive add +1
                queue.add(new Pair<>(node.right, line + 1));
            }
        }
      // convert map to result list
       return map.values().stream().collect(Collectors.toList());
}
    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(10);
        root.left.left.right = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(10);
        root.right.left = new TreeNode(9);

        TopViewOfBT solution = new TopViewOfBT();

        // Get the top view traversal
        List<Integer> topView = solution.topView(root);

        // Print the result
        System.out.println("Top View Traversal:");
        for (int node : topView) {
            System.out.print(node + " ");
        }
    }
}
