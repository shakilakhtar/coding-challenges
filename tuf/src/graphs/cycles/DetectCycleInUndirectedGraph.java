package graphs.cycles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DetectCycleInUndirectedGraph {
    public boolean isCycle(int V, List<Integer>[] adj) {
        boolean[] visited =  new boolean[V];
        for (int i = 0; i < V; i++) {
            //call dfs for unvisited components
            if (visited[i] == false){
               if(dfs(i, -1, visited, adj) == true){
                   return true;
               }
            }
        }
        return false;
    }

    private boolean dfs(int node, int parent, boolean[] visited,List<Integer>[] adjList){

        visited[node] =  true;
        //get adjacency node from list
        for (int adjacencyNode: adjList[node]) {
            if (visited[adjacencyNode] == false){
                //call dfs for unvisited node
                if(dfs(adjacencyNode, node, visited, adjList) == true){
                    return true;
                } else if (adjacencyNode != parent) {
                    return  true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 6;
        List<Integer> adj[] = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        adj[0].addAll(Arrays.asList(1, 3));
        adj[1].addAll(Arrays.asList(0, 2, 4));
        adj[2].addAll(Arrays.asList(1, 5));
        adj[3].addAll(Arrays.asList(0, 4));
        adj[4].addAll(Arrays.asList(1, 3, 5));
        adj[5].addAll(Arrays.asList(2, 4));

        /* Creating an instance of
        Solution class */
        DetectCycleInUndirectedGraph sol = new DetectCycleInUndirectedGraph();

        /* Function call to detect
        cycle in given graph. */
        boolean ans = sol.isCycle(V, adj);

        // Output
        if (ans)
            System.out.println("The given graph contains a cycle.");
        else
            System.out.println("The given graph does not contain a cycle.");
    }
}
