package bst.basics;

import binarytrees.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FloorAndCeilInBST {
    public List<Integer> floorCeilOfBST(TreeNode root, int key) {
       int floor = -1;
       int ceil = -1;
       TreeNode current = root;
       while (current != null){
           if (current.data == key){
               floor = current.data;
               break;
           } else if (current.data < key) {
               floor = current.data;
               current = current.right;
           }else {
               current = current.left;
           }
       }
       //reset to get ceil
        current = root;
       while (current != null){
           if (current.data == key){
               ceil = current.data;
               break;
           } else if (current.data > key) {
               ceil = current.data;
               current = current.left;
           }else {
               current = current.right;
           }
       }
       return Arrays.asList(floor,ceil);
    }
    public static void main(String[] args) {

    }
}
