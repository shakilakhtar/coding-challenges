package graphs.traversalproblems;

import java.util.Arrays;

public class RottenOranges {
    class GridRowColTime{
        int row;
        int col;
        int time;

        public GridRowColTime(int row, int col, int time){
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
    public int orangesRotting(int[][] grid) {
      int n  = grid.length;
      int m = grid[0].length;
      int [][] visited = new int[n][m];

        for (int i = 0; i <n; i++) {
            Arrays.copyOf(grid[i],0);
        }

        return 0;
    }

    private void  bfs(int row, int col, int[][] visited, int[][] grid){


    }
    public static void main(String[] args) {

    }
}
