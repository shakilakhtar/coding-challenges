package bst.faqs;

import binarytrees.TreeNode;

import java.util.Stack;

public class BSTIterator {
    Stack<TreeNode> stack = new Stack<>();
    public BSTIterator(TreeNode root) {
        pushAllToStack(root);
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {
     TreeNode tempNode = stack.pop();
     pushAllToStack(tempNode.right);
     return tempNode.data;
    }

    private void pushAllToStack(TreeNode node){
        while (node!= null){
            stack.push(node);
            node = node.left;
        }
    }
    public static void main(String[] args) {

    }
}
