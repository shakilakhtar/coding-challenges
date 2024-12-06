package binarytrees.faqs;

import binarytrees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class RightSideViewOfBT {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightView = new ArrayList<>();
        rightSideRecursion(root,0,rightView);
        return rightView;
    }

    private void rightSideRecursion(TreeNode node, int level, List<Integer> result){
        if (node == null){
            return;
        }
        //check if level is available than size will be same length
        if (result.size() == level){
            result.add(node.data);
        }
        rightSideRecursion(node.right, level + 1,result);
        rightSideRecursion(node.left, level + 1, result);
    }
    public static void main(String[] args) {

    }
}
