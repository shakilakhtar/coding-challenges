package graphs.shortestpathalgos;

import java.util.*;

public class DijkstraAlgorithm {
    public  int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        //priority queue to keep min distance at top ( array[0] as distance array[1] as node)
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));

        //distance array
        int[] distances = new int[V];
        Arrays.fill(distances, Integer.MAX_VALUE);

        //distance of source from itself

        distances[S] = 0;

        //add the source node (starting point in the PQ)
        pq.add(new int[]{0, S});

        while (!pq.isEmpty()){
            int[] top = pq.poll();
            //get the tentative distance
            int dist = top[0];
            //get the node
            int node =  top[1];
            
            //traverse all node's neighbour 
            for (List<Integer> l : adj.get(node)) {
                //adjacent node
                int adjNode = l.get(0);
                //edge weight
                int edgeWeight =  l.get(1);

                //If the tentative distance to reach adjacent node is smaller
                // than the known distance
                if (dist + edgeWeight < distances[adjNode]){
                    //update the known distance
                    distances[adjNode] = dist + edgeWeight;

                    //push the entry in the priority queue
                    pq.add(new int[]{distances[adjNode], adjNode});
                }
            }
        }
        return distances;
    }
    public static void main(String[] args) {

    }
}
