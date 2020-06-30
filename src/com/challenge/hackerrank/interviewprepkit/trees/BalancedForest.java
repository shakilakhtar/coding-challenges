package com.challenge.hackerrank.interviewprepkit.trees;

import java.util.*;

/**
 * Greg has a tree of nodes containing integer data. He wants to insert a node with some non-zero integer value somewhere into the tree. His goal is to be able to cut two edges and have the values of each of the three new trees sum to the same amount. This is called a balanced forest. Being frugal, the data value he inserts should be minimal. Determine the minimal amount that a new node can have to allow creation of a balanced forest. If it's not possible to create a balanced forest, return -1.
 * <p>
 * For example, you are given node values  and . It is the following tree:
 * <p>
 * image
 * The blue node is root, the first number in a node is node number and the second is its value. Cuts can be made between nodes  and  and nodes  and  to have three trees with sums ,  and . Adding a new node  of  to the third tree completes the solution.
 * <p>
 * Function Description
 * <p>
 * Complete the balancedForest function in the editor below. It must return an integer representing the minimum value of  that can be added to allow creation of a balanced forest, or  if it is not possible.
 * <p>
 * balancedForest has the following parameter(s):
 * <p>
 * c: an array of integers, the data values for each node
 * edges: an array of 2 element arrays, the node pairs per edge
 * Input Format
 * <p>
 * The first line contains a single integer, , the number of queries.
 * <p>
 * Each of the following  sets of lines is as follows:
 * <p>
 * The first line contains an integer, , the number of nodes in the tree.
 * The second line contains  space-separated integers describing the respective values of , where each  denotes the value at node .
 * Each of the following  lines contains two space-separated integers,  and , describing edge  connecting nodes  and .
 * Constraints
 * <p>
 * Each query forms a valid undirected tree.
 * Subtasks
 * <p>
 * For  of the maximum score:
 * <p>
 * For  of the maximum score:
 * <p>
 * Output Format
 * <p>
 * For each query, return the minimum value of the integer . If no such value exists, return  instead.
 * <p>
 * Sample Input
 * <p>
 * 2
 * 5
 * 1 2 2 1 1
 * 1 2
 * 1 3
 * 3 5
 * 1 4
 * 3
 * 1 3 5
 * 1 3
 * 1 2
 * Sample Output
 * <p>
 * 2
 * -1
 * Explanation
 * <p>
 * We perform the following two queries:
 * <p>
 * The tree initially looks like this:
 * image
 * Greg can add a new node  with  and create a new edge connecting nodes  and . Then he cuts the edge connecting nodes  and  and the edge connecting nodes  and . We now have a three-tree balanced forest where each tree has a sum of .
 * <p>
 * image
 * In the second query, it's impossible to add a node in such a way that we can split the tree into a three-tree balanced forest so we return .
 */
public class BalancedForest {


    static class Node {
        long cost;
        boolean visited = false, v2 = false;
        List<Integer> adjacent = new ArrayList<>();

        @Override
        public String toString() {
            return "Node{" +
                    "cost=" + cost +
                    ", v1=" + visited +
                    ", v2=" + v2 +
                    ", adjacent=" + adjacent +
                    '}';
        }

        public Node(long cost) {
            this.cost = cost;
        }
    }

    static long mini, sum;
    static Set<Long> s = new HashSet<>();
    static Set<Long> q = new HashSet<>();

    static long balancedForest(int[] nodeValues, int[][] edges) {
         s = new HashSet<>();
         q = new HashSet<>();

        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < nodeValues.length; i++) {
            nodes.add(new Node(nodeValues[i]));
        }

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int a = edge[0] - 1;
            int b = edge[1] - 1;
            nodes.get(a).adjacent.add(b);
            nodes.get(b).adjacent.add(a);
        }

        mini = sum = dfs(0, nodes);
        solve(0, nodes);

        return mini == sum ? -1 : mini;
    }

    // s contains sums encountered during depth first search excluding those from the root to the current node.
    // q contains sums encountered during depth first search from the root to current node.
    private static void solve(int p, List<Node> nodes) {
        Node node = nodes.get(p);
        if (node.v2) return;
        node.v2 = true;

        long[] x = {2 * node.cost,
                2 * sum - 4 * node.cost,
                sum - node.cost};
        long[] y = {3 * node.cost - sum,
                (sum - node.cost) / 2 - node.cost};

        // If removing the edge above the current node (node variable defined at the top of this method)
        // gives two trees whose total values are the same, then the node we add should have that
        // same value too to get 3 trees (one of which is our single node that we added) with the same value.
        if (sum % 2 == 0 && node.cost == (sum / 2)) mini = Math.min(mini, sum / 2);

        // case 1a: When two non-overlapping subtrees in the overall tree have the same total value.
        if (s.contains(node.cost)) {// ||                      // case 1a
//                q.contains(2*node.cost) ) {                  // ?
            if (y[0] >= 0) mini = Math.min(mini, y[0]);
        }

        // case 1b: (part B): Two non-overlapping subtrees in the overall tree.
        // case 2b: One edge to be removed is below the other edge to be removed in the overall tree.
        if (s.contains(sum - 2 * node.cost) ||                 // case 1b (part B)
                q.contains(sum - node.cost)) {                // case 2b
            if (y[0] >= 0) mini = Math.min(mini, y[0]);
        }

        // case 1b: (part A): Two non-overlapping subtrees in the overall tree.
        // case 2a: One edge to be removed is below the other edge to be removed in the overall tree.
        if ((sum - node.cost) % 2 == 0) {
            if (s.contains((sum - node.cost) / 2) ||            // case 1b (part A)
                    q.contains((sum + node.cost) / 2)) {        // case 2a
                if (y[1] >= 0) mini = Math.min(mini, y[1]);
            }
        }

        q.add(node.cost);

        for (int i = 0; i < node.adjacent.size(); i++) {  // DFS!!
            solve(node.adjacent.get(i), nodes);           // recursive call
        }

        q.remove(node.cost);
        s.add(node.cost);
    }


    private static long dfs(int p, List<Node> nodes) {
        Node node = nodes.get(p);
        if (node.visited) return 0;
        node.visited = true;
        for (int i = 0; i < node.adjacent.size(); i++) {
            node.cost += dfs(node.adjacent.get(i), nodes);
        }
        return node.cost;
    }

    public static void main(String[] args) {

    }
}
