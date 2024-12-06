package recursion.faqshard;

import java.util.ArrayList;
import java.util.List;

public class MColoringProblem {
    boolean graphColoring(int[][] edges, int m, int n) {
        // Create adjacency list representation of the graph
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        // Build the graph from edges
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        // Initialize all colors to 0 (uncolored)
        int [] colors =  new int[n];
        //solve from the first node
        return solveColoring(0, m,n,colors, adjList);
    }

    private boolean solveColoring(int node, int m, int n, int[] colors,
                                  List<List<Integer>> adjList){

        //if all nodes are colored
        if (n == node){
            return true;
        }
        // Try all colors from 1 to m
        for (int i = 1; i <= m; i++) {

            // Check if it is safe to color the node with color i
            if (isSafeToColor(i, node, colors, adjList)){
                // Assign color i to node
                colors[node] = i;
                // Recursively try to color the next node
                if (solveColoring(node + 1, m, n, colors, adjList)){
                    return true;
                }
                // Reset color if it doesn't lead to a solution
                colors[node] = 0;
            }

        }
        return false;
    }

    private boolean isSafeToColor(int col, int node, int[] colors, List<List<Integer>> adjList){

        //check adjacent nodes color
        for (int neighbourColor : adjList.get(node)) {
            if (colors[neighbourColor] == col){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {

    }
}
