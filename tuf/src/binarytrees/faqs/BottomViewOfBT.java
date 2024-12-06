package binarytrees.faqs;

import binarytrees.TreeNode;
import binarytrees.TreeNodeWithDist;

import java.util.*;
import java.util.stream.Collectors;

public class BottomViewOfBT {
    public List<Integer> bottomView(TreeNodeWithDist root) {

        if (root == null){
            return null;
        }
        //sorted map to store distance and node
        Map<Integer, Integer> map = new TreeMap<>();

        Queue<TreeNodeWithDist> queue = new LinkedList<>();
        //set root distance as axis line 0
        root.dist = 0;
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNodeWithDist nd = queue.poll();
            int hd =  nd.dist;
            //check if node is present in the map
            map.put(hd, nd.data);
            if (nd.left != null){
                nd.left.dist = hd - 1;
                queue.add(nd.left);
            }
            if (nd.right != null){
                nd.right.dist = hd + 1;
            }
        }
     return map.values().stream().collect(Collectors.toList());
    }
    public static void main(String[] args) {

    }
}
