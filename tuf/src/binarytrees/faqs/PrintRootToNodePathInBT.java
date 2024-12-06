package binarytrees.faqs;

import binarytrees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PrintRootToNodePathInBT {
    public List<List<Integer>> allRootToLeaf(TreeNode root) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfsPath(root,path,allPaths);

        return allPaths;
    }

    private void dfsPath(TreeNode node, List<Integer> currentPath, List<List<Integer>> allPaths){

        if (node == null){
            return;
        }
        currentPath.add(node.data);

        //if node is a leaf node then end path
        if (node.left == null && node.right == null){
            allPaths.add(new ArrayList<>(currentPath));
        }else {
            dfsPath(node.left, currentPath, allPaths);
            dfsPath(node.right, currentPath, allPaths);
        }
        // Backtrack by removing the last node from the path
        currentPath.remove(currentPath.size() - 1);

    }
    public static void main(String[] args) {

    }
}
