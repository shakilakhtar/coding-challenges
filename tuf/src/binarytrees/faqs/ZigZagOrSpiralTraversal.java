package binarytrees.faqs;

import binarytrees.TreeNode;

import java.util.*;

public class ZigZagOrSpiralTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> traversals = new ArrayList<>();
        if (root == null){
            return traversals;
        }
        Queue<TreeNode> queue =  new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()){
            int queueSize = queue.size();

            List<Integer> level = new ArrayList<>(Collections.nCopies(queueSize,0));
            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.poll();
                //decide based on direction
                int idx = leftToRight ? i : queueSize - 1 -i;
                level.set(idx,node.data);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            //change level direction
            leftToRight = !leftToRight;
            traversals.add(level);
        }
        return traversals;
    }
    public static void printResult(List<List<Integer>> result) {
        for (List<Integer> row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        ZigZagOrSpiralTraversal solution = new ZigZagOrSpiralTraversal();

        // Get the zigzag level order traversal
        List<List<Integer>> result = solution.zigzagLevelOrder(root);

        // Print the result
        printResult(result);
    }

}
