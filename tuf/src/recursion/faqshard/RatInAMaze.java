package recursion.faqshard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RatInAMaze {
    static List<String> results  = new ArrayList<>();

    public static List<String> findPath(int[][] grid) {
        int len =  grid.length;
        results.clear();
        if ((grid[0][0] == 0) || grid[len - 1][len - 1] == 0){
            return results;
        }
        // Start finding paths from (0, 0)
        recPath(grid,0, 0, "", len);
        // Sort the result paths
        Collections.sort(results);
        return results;
    }

    private static void recPath(int[][] grid, int i, int j, String path, int len){

        //base case If destination is reached, add path to result
        if (i == len - 1 && j == len - 1){
            results.add(path);
            return;
        }
        // If cell is blocked, return
        if (grid[i][j] == 0){
            return;
        }

        // Mark cell as visited by setting it to 0
        grid[i][j] = 0;

        //move up if possible
        if(i > 0 ) {
            recPath(grid, i - 1, j, path + 'U', len);
        }
        //move left if possible
        if(j > 0 ) {
            recPath(grid, i, j - 1, path + 'L', len);
        }
        //move down
        if(i < len -1) {
            recPath(grid, i + 1, j, path + 'D', len);
        }
        //move right
        if(j < len -1) {
            recPath(grid, i, j + 1, path + 'R', len);
        }

        // Unmark cell as visited by setting it to 1 // backtrack
        grid[i][j] = 1;
    }
    public static void main(String[] args) {
        int[][] grid = {
                {1, 0, 0, 0, 0},
                {1, 1, 0, 1, 1},
                {0, 1, 0, 0, 1},
                {0, 1, 1, 1, 1},
                {0, 0, 0, 0, 1}
        };

        List<String> paths = findPath(grid);

        for (String path : paths) {
            System.out.println(path);
        }
    }
}
