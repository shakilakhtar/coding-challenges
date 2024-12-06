package graphs.cycles;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleInDirectedGraph {
    public boolean isCyclic(int N, List<Integer>[] adj) {
     boolean[] visited = new boolean[N];
     boolean[] pathVisited  = new boolean[N];

        for (int i = 0; i < N; i++) {
            if (dfs(i, visited, pathVisited, adj) == true){
                return true;
            }
        }
        return false;
    }

    private boolean dfs(int node, boolean[] visited, boolean[] pathVisited,
                        List<Integer>[] adj){
        visited[node]= true;
        pathVisited[node] = true;

        for (int n : adj[node]) {
            //when the node is not visited
            if (!visited[n]) {
                if (dfs(n, visited, pathVisited, adj) == true) {
                    return true;
                }
            }
            //if the node has been previously visited
            //but it has to ve visited on the same path
            else if (pathVisited[n]== true) {
                return true;
            }
        }
        pathVisited[node] = false;
        return false;
    }
    public static void main(String[] args) {
        int V = 6;
        List<Integer> adj[] = new List[V];
        for(int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }

        adj[0].add(1);
        adj[1].add(2); adj[1].add(5);
        adj[2].add(3);
        adj[3].add(4);
        adj[4].add(1);

        /* Creating an instance of
        Solution class */
        DetectCycleInDirectedGraph sol = new DetectCycleInDirectedGraph();

        /* Function call to determine if cycle
        exists in given directed graph */
        boolean ans = sol.isCyclic(V, adj);

        // Output
        if(ans)
            System.out.println("The given directed graph contains a cycle.");
        else
            System.out.println("The given directed graph does not contain a cycle.");
    }
}
