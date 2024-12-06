package graphs.traversals;

import java.util.*;

public class TraversalTechniques {

    public List<Integer> dfsOfGraph(int V, List<Integer> adj[]) {
      boolean[] visited =  new boolean[V];
      //traversal list
        List<Integer> results =  new ArrayList<>();

        //traverse all nodes
        for (int i = 0; i < V; i++) {
            if (!visited[i]){
                visited[i] = true;
                bfs(i, adj, visited, results);
            }
        }
       return results;
    }

    public List<Integer> bfsOfGraph(int V, List<Integer> adj[]) {
        boolean[] visited =  new boolean[V];
        //traversal list
        List<Integer> results =  new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (!visited[i]){
                dfs(i, adj, visited, results);
            }
        }

        return results;
    }

    private void dfs(int node, List<Integer>[] adjList, boolean[] visited,
                     List<Integer> results){
        visited[node] = true;
        results.add(node);
        for (int neighbour: adjList[node]) {
            if (!visited[neighbour]){
                dfs(neighbour,adjList,visited,results);
            }
        }
    }

    private void bfs(int node, List<Integer>[] adjList, boolean[] visited,
                     List<Integer> results){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            int nd = queue.poll();
            results.add(nd);
            for(int neighbour:  adjList[nd]){
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.add(neighbour);
                }
            }
        }
    }
    public static void main(String[] args) {
        int V = 5;
        List<Integer>[] adj = new List[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        adj[0].addAll(Arrays.asList(2, 3, 1));
        adj[1].add(0);
        adj[2].addAll(Arrays.asList(0, 4));
        adj[3].add(0);
        adj[4].add(2);

        // Creating instance of Solution class
        TraversalTechniques sol = new TraversalTechniques();

        // Function call to get the BFS traversal of graph
        List<Integer> bfs = sol.bfsOfGraph(V, adj);

        // Function call to get the DFS traversal of graph
        List<Integer> dfs = sol.dfsOfGraph(V, adj);

        // Output
        System.out.println("The BFS traversal of the given graph is: " + bfs);
        System.out.println("The DFS traversal of the given graph is: " + dfs);
    }
}
