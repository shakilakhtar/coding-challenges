package com.challenge.leetcode.highfreqency;

import com.challenge.leetcode.topquestions.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root ==null) return "";
        //doing level order traversal of tree
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node == null){
                // if null add "n " you can add what you want for null ex '?' '#' etc.
                sb.append("n ");
                continue;
            }
            sb.append(node.val+" ");
            queue.add(node.left);
            queue.add(node.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data =="") return null;
        Queue<TreeNode> queue = new LinkedList<>();
        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.add(root);
        for (int i=1;i< values.length;i++){
            TreeNode parent = queue.poll();
            if(!values[i].equals("n")){
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                queue.add(left);
            }
            if(!values[++i].equals("n")){
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                queue.add(right);
            }
        }
        return root;
    }
}
