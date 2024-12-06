package binarytrees;

public class TreeNodeWithDist {
    public int data;
    public TreeNodeWithDist left;
    public TreeNodeWithDist right;
    public int dist;

    public TreeNodeWithDist(int val){
        this.data = val;
        left = null;
        right = null;
    }
}
