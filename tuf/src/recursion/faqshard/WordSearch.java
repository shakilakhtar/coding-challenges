package recursion.faqshard;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i <board.length ; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //if the first character matches start search
                if (board[i][j] == word.charAt(0)){
                    // if the word found return true
                    if (recFunc(board, i, j, word, 0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean recFunc(char[][] board, int i, int j, String word, int wIdx){
        // If all characters of the word are found
        if (wIdx == word.length()){
            return true;
        }
        // Boundary conditions and character mismatch check
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length
                || word.charAt(wIdx) != board[i][j]){
            return false;
        }
        // Temporarily mark the cell as visited
        char temp  =  board[i][j];
        board[i][j] = ' ';
        // Check all four possible directions (down, up, right, left)
        boolean result
                = recFunc(board, i + 1, j, word, wIdx + 1)||
                recFunc(board, i - 1, j, word, wIdx + 1) ||
                recFunc(board, i, j + 1, word, wIdx + 1) ||
                recFunc(board, i, j - 1, word, wIdx + 1);

        board[i][j] = temp;
        return result;

    }

    public static void main(String[] args) {

    }
}
