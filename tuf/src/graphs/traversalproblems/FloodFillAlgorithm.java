package graphs.traversalproblems;

import java.util.Arrays;

public class FloodFillAlgorithm {
    int[] delRow =  {-1, 0, 1, 0};
    int[] delCol = {0, 1, 0, -1};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int initialColor = image[sr][sc];
        //to store the updated image taking new duplicate matrix to avoid data modification
        int[][] results = new int[image.length][image[0].length];
        for (int i = 0; i < image.length ; i++) {
            results[i] = Arrays.copyOf(image[i], image[i].length);
        }
        // start dfs from the starting row and colum
        dfs(sr, sc, results,image, newColor, initialColor);

        return results;
    }

    private void dfs(int row, int col, int[][] result, int[][] image,
                     int newColor, int initialColor){
        //color with new color
        result[row][col] = newColor;
        int n = image.length;
        int m = image[0].length;

        //color its neighbour traverse 4 neighbour
        for (int i = 0; i < 4 ; i++) {
                int nrow =  row  + delRow[i];
                int ncol =  col + delCol[i];

                //check for valid unvisited pixels having same initial color
            if (isValid(nrow, ncol, n, m) && image[nrow][ncol] == initialColor
                    && result[nrow][ncol] != newColor){
                //call dfs
                dfs(nrow, ncol, result, image, newColor, initialColor);
            }
        }
    }
    private boolean isValid(int i, int j, int n, int m){
        if (i < 0 || i >= n) return false;
        if (j < 0 || j>= m) return false;

        return true;
    }
    public static void main(String[] args) {
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int sr = 1, sc = 1;
        int newColor = 2;

        // Creating an instance of Solution class
        FloodFillAlgorithm sol = new FloodFillAlgorithm();

        // Function call to find the number of islands in given grid
        int[][] ans = sol.floodFill(image, sr, sc, newColor);

        System.out.println("Image after performing flood fill algorithm:\n");

        for (int[] row : ans) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}
