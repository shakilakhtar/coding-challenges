package graphs.traversalproblems;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves {
    private int[] deltaRows = {-1, 0, 1, 0};
    private int[] deltaCols = {0, 1, 0, -1};

    public int numberOfEnclaves(int[][] grid) {
        int n  = grid.length;
        int m = grid[0].length;
        boolean[][] visited =  new boolean[n][m];
        //traverse the grid and add border land cells BFS
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m; j++) {
                if ((i == 0  || i == n - 1 || j == m - 1 || j == 0)
                && grid[i][j] == 1){
                    bfsFromBoundryLand(i, j ,visited, grid);
                }
            }
        }
        
        //count the number of enclaves 
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && visited[i][j] == false){
                    count++;
                }
            }
        }
        return count;
    }

    private void bfsFromBoundryLand(int row, int col, boolean[][] visited, int [][] grid){
        int n  = grid.length;
        int m = grid[0].length;
        visited[row][col] = true;
        Queue<GridRowCol> queue = new LinkedList<>();
        queue.add(new GridRowCol(row, col));

        while (!queue.isEmpty()){
            int r =  queue.peek().row;
            int c =  queue.peek().col;
            queue.remove();

            for (int i = 0; i < 4; i++) {
                int nrow =  row + deltaRows[i];
                int ncol =  row + deltaCols[i];

                // traverse
                if (isValid(nrow, ncol,n,m) && grid[nrow][ncol] == 1
                && visited[nrow][ncol] == true){
                    queue.add(new GridRowCol(nrow, ncol));
                }
            }
        }
    }
    private boolean isValid(int i, int j, int n, int m){
        if (i < 0 || i >= n) return false;
        if (j < 0 || j >= m) return false;

        return true;
    }
    public static void main(String[] args) {

        int[][] grid = {
                {0, 0, 0, 1},
                {1, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0}
        };

        /* Creating an instance of
        Solution class */
        NumberOfEnclaves sol = new NumberOfEnclaves();

        // Function call to get number of enclaves
        int ans = sol.numberOfEnclaves(grid);

        System.out.println("The number of enclaves in given grid are: " + ans);
    }
}
