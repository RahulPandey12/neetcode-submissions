
class Solution {

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> res = new ArrayList<>();

        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        backtrack(0, board, res);

        return res;
    }

    private void backtrack(int col, char[][] board,
                           List<List<String>> res) {

        if (col == board.length) {
            res.add(construct(board));
            return;
        }

        for (int row = 0; row < board.length; row++) {

            if (isSafe(row, col, board)) {

                // 1. Choose
                board[row][col] = 'Q';

                // 2. Explore next column
                backtrack(col + 1, board, res);

                // 3. Backtrack
                board[row][col] = '.';
            }
        }
    }

    private boolean isSafe(int row, int col, char[][] board) {

        int duprow = row;
        int dupcol = col;

        // Check upper-left diagonal
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            row--;
            col--;
        }

        row = duprow;
        col = dupcol;

        // Check same row towards left
        while (col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            col--;
        }

        row = duprow;
        col = dupcol;

        // Check lower-left diagonal
        while (row < board.length && col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            row++;
            col--;
        }

        return true;
    }

    private List<String> construct(char[][] board) {

        List<String> res = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            res.add(new String(board[i]));
        }

        return res;
    }
}
