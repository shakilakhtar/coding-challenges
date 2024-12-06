package bst.faqs;

import binarytrees.TreeNode;

import java.util.Stack;

class BSTIterator2 {
    Stack<TreeNode> stack = new Stack<>();
    boolean reverse = true;
    public BSTIterator2(TreeNode root, boolean isReverse) {
        reverse = isReverse;
        pushAllToStack(root);
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {
        TreeNode tempNode = stack.pop();
        if (reverse == false) {
            pushAllToStack(tempNode.right);
        }else {
            pushAllToStack(tempNode.left);
        }
        return tempNode.data;
    }

    private void pushAllToStack(TreeNode node){
        while (node!= null){
            stack.push(node);
            if (reverse ==true){
                node = node.right;
            }else {
                node = node.left;
            }
        }
    }
}
public class TwoSumInBST {
    public boolean twoSumBST(TreeNode root, int k) {
        if (root == null){
            return false;
        }
        BSTIterator2 l = new BSTIterator2(root, false);
        BSTIterator2 r =  new BSTIterator2(root,true);

        int leftPtr =  l.next();
        int rightPtr = r.next();

        while (leftPtr < rightPtr){
            if (leftPtr + rightPtr == k){
                return true;
            } else if (leftPtr + rightPtr < k) {
                leftPtr = l.next();
            }else {
                rightPtr = r.next();
            }
        }
        return false;
    }
    public static void main(String[] args) {

    }
}
