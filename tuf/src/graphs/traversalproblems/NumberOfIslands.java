package graphs.traversalproblems;

import java.util.LinkedList;
import java.util.Queue;

class GridRowCol{
    int row;
    int col;

    public GridRowCol(int row, int col){
        this.row = row;
        this.col =  col;
    }
}
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
     int n  = grid.length;
     int m  =  grid[0].length;
     int [][] visited = new int[n][m];
     int count = 0;
        for (int i = 0; i <n; i++) {
            for (int j = 0; j <m ; j++) {
                if (visited[i][j] == 0 && grid[i][j] == '1'){
                    count++;
                    bfs(i, j, visited, grid);
                }
            }
        }
        return count;
    }

    private void bfs(int row, int col, int[][] visited, char[][] grid){
        visited[row][col] =  1;
        Queue<GridRowCol> queue = new LinkedList<>();
        queue.add(new GridRowCol(row, col));
        int n  = grid.length;
        int m  =  grid[0].length;

        while (!queue.isEmpty()){
            int r = queue.peek().row;
            int c = queue.peek().col;
            queue.remove();
            //traverse the neighbour and mark them if land
            for (int deltaRow = -1; deltaRow <= 1; deltaRow++) {
                for (int deltaCol = -1; deltaCol <= 1 ; deltaCol++) {
                    int newRow =  r + deltaRow;
                    int newCol =  c + deltaCol;
                    //add condition to check boundaries and land
                    if (isValid(newRow, newCol, n, m)
                     && visited[newRow][newCol] == 0 && grid[newRow][newCol] == '1') {
                        visited[newRow][newCol] = 1;
                        queue.add(new GridRowCol(newRow, newCol));
                    }
                }
            }
        }
    }

    private boolean isValid(int i, int j,
                            int n, int m) {
        if (i < 0 || i >= n) return false;
        if (j < 0 || j >= m) return false;
        // Return true if cell is valid
        return true;
    }
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '0', '1'},
                {'1', '0', '0', '0', '0'},
                {'1', '1', '1', '0', '1'},
                {'0', '0', '0', '1', '1'}
        };

        // Creating an instance of Solution class
        NumberOfIslands sol = new NumberOfIslands();

        /* Function call to find the
        number of islands in given grid */
        int ans = sol.numIslands(grid);

        System.out.println("The total islands in given grids are: " + ans);

    }
}
