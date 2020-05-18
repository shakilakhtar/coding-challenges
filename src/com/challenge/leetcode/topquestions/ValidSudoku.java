package com.challenge.leetcode;
/**
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 *
 * A partially filled sudoku which is valid.
 *
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 *
 * Example 1:
 *
 * Input:
 * [
 *   ["5","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: true
 * Example 2:
 *
 * Input:
 * [
 *   ["8","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being
 *     modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 * Note:
 *
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 * The given board contain only digits 1-9 and the character '.'.
 * The given board size is always 9x9.
 *
 * @author Shakil Akhtar
 */
public class ValidSudoku {

    public static boolean isValidSudoku(char[][] board) {
        for (int row=0;row<board[0].length;row++){
            for (int col=0;col<board[0].length;col++){
                if(board[row][col]!='.'){
                    char target = board[row][col];
                    board[row][col] = '.';
                    if(!isMatrixValid(board, target, row, col))
                        return false;
                    board[row][col] = target;                }
            }
        }
        return true;
    }

    public static boolean isMatrixValid(char[][] board,char target,int r, int c){
        int row = r < 3 ? 0 : r < 6 ? 3 : 6;
        int col = c < 3 ? 0 : c < 6 ? 3 : 6;
         //traverse sub matrix
        for(int i=0;i<3;i++){
            int r1=row+i;
            for(int j=0;j<3;j++){
                int c1=col+j;
                if(board[r1][c1]==target){
                    return false;
                }
            }
        }
        for(int i = 0; i < board.length; i++)
            if(board[i][c] == target)
                return false;
        for(int j = 0; j < board[0].length; j++)
            if(board[r][j] == target)
                return false;
            return true;
    }


    public static void main(String[] args) {

        char[][] c = {{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        boolean isValid = isValidSudoku(c);
        System.out.println(isValid);

    }
}
