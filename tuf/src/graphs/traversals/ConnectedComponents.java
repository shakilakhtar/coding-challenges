package graphs.traversals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ConnectedComponents {
    public int findNumberOfComponent(int E, int V, List<List<Integer>> edges) {
        // To store adjacency list
        List<Integer>[] adjLs = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adjLs[i] = new ArrayList<>();
        }

        // Add edges to adjacency list
        for (int i = 0; i < E; i++) {
            adjLs[edges.get(i).get(0)].add(edges.get(i).get(1));
            adjLs[edges.get(i).get(1)].add(edges.get(i).get(0));
        }
        //visited array
        boolean[] visited =  new boolean[V];
        // Variable to store number of components
        int count = 0;
        for (int i = 0; i < V; i++) {
            if (!visited[i]){
                count++;
                bfs(i,adjLs,visited);
            }
        }
        return count;
    }
    private void bfs(int node, List<Integer>[] adjList, boolean[] visited){
       //mark the node as visited
        visited[node] = true;
        // Queue required for BFS traversal
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            // Get the node
            int n =  queue.poll();
            for (int neighbour : adjList[n]){
                if (!visited[neighbour]){
                    visited[neighbour] = true;
                    queue.add(neighbour);
                }

            }
        }
    }

    private void dfs(int node, List<Integer>[] adjList, boolean[] visited){
        //mark the node as visited
        visited[node] = true;

        // Traverse its unvisited neighbours
        for (int neighbour: adjList[node]){
            if (!visited[neighbour]){
                // Recursively perform DFS
                dfs(neighbour,adjList,visited);
            }
        }
    }
    public static void main(String[] args) {

    }
}
