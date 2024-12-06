package graphs.cycles;

import java.util.List;
import java.util.Stack;

public class TopologicalSort {
    public int[] topoSort(int V, List<Integer>[] adj) {
       boolean[] visited = new boolean[V];
       Stack<Integer> stack  = new Stack<>();
        for (int i = 0; i <V ; i++) {
            if (!visited[i]){
                dfs(i, visited,stack, adj);
            }
        }
        // just iterate over stack and return
        int[] ts = new int[V];
        int i = 0;
        while (!stack.isEmpty()){
            int e = stack.pop();
            ts[i] = e;
            i++;
        }
        return ts;
    }

    private void dfs(int node, boolean[] visited, Stack<Integer> stack, List<Integer>[] adj){
        visited[node] = true;
        for (int nd: adj[node]) {
            if (!visited[nd]){
                dfs(nd,visited, stack,adj);
            }
        }
     // keep dfs completed node into stack
        stack.push(node);
    }

    public static void main(String[] args) {

    }
}
