package com.challenge.tree;

import com.challenge.leetcode.topquestions.*;

public class BoundaryTraversalBinaryTree {

    public void boundaryTraversal(TreeNode root){
        PrintLeftNodesExceptLeafNode.printLeftNodesExceptLeafNode(root);
        PrintLeafOfBinaryTree.printLeafOfBinaryTree(root);
        PrintRightNodeExceptLeaf.printRightNodeExceptLeaf(root.right);
    }
}
