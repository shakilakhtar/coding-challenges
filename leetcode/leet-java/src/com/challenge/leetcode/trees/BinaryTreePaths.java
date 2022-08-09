package com.challenge.leetcode.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. Binary Tree Paths
 *
 * Given the root of a binary tree, return all root-to-leaf paths in any order.
 *
 * A leaf is a node with no children.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,null,5]
 * Output: ["1->2->5","1->3"]
 * Example 2:
 *
 * Input: root = [1]
 * Output: ["1"]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 100].
 * -100 <= Node.val <= 100
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths =  new ArrayList<>();
        getPath(root,"",paths);
        return paths;
    }
    public static void getPath(TreeNode root,String path,List<String> paths){
        if(root == null) return;
        String newRunningPath =  path+String.valueOf(root.val);
        if(root.left==null && root.right==null) {
            paths.add(newRunningPath);
            return;
        }
        newRunningPath+="->";
        getPath(root.left,newRunningPath,paths);
        getPath(root.right,newRunningPath,paths);

    }
}
