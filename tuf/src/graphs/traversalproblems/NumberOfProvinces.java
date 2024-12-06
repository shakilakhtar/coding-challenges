package graphs.traversalproblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumberOfProvinces {
    public int numProvinces(int[][] adj) {
        int V = adj.length;

        List<Integer>[] adjList = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new ArrayList<>();
        }
        //covert adj matrix to list
        for (int i = 0; i <V ; i++) {
            for (int j = 0; j <V; j++) {
                if (adj[i][j] == 1 && i != j){
                    adjList[i].add(j);
                    adjList[j].add(i);
                }
            }
        }
        boolean[] visited =  new boolean[V];
        //count
        int count = 0;
        for (int i = 0; i < V; i++) {
            if (!visited[i]){
                count++;
                bfs(i, adjList,visited);
            }
        }
        return count;
    }
    private void bfs(int node, List<Integer>[] adjList, boolean[] visited){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()){
            int nd= queue.poll();
            visited[nd] = true;

            for(int neighbour:  adjList[nd]){
                if (!visited[neighbour]){
                    visited[neighbour] = true;
                    queue.add(neighbour);
                }
            }
        }
    }
    public static void main(String[] args) {
        int[][] adj = {
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 0},
                {1, 0, 0, 1}
        };

        /* Creating an instance of
        Solution class */
        NumberOfProvinces sol = new NumberOfProvinces();

        /* Function call to find the
        provinces in the given graph */
        int ans = sol.numProvinces(adj);

        System.out.println("The number of provinces in the given graph is: " + ans);
    }
}
