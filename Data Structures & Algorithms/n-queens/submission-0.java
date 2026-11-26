
class Solution {
    List<List<String>> result;

    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();

        char[][] board = new char[n][n];

        // Initialize board with empty cells
        for(int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        solve(board, 0, n);

        return result;
    }

    public void solve(char[][] board, int row, int n) {

        // Base case: All queens have been placed
        if(row == n) {
            List<String> temp = new ArrayList<>();

            for(int i = 0; i < n; i++) {
                temp.add(new String(board[i]));
            }

            result.add(temp);
            return;
        }

        // Try placing queen in every column of current row
        for(int col = 0; col < n; col++) {

            if(isSafe(board, row, col, n)) {

                // 1. Choose
                board[row][col] = 'Q';

                // 2. Explore
                solve(board, row + 1, n);

                // 3. Backtrack
                board[row][col] = '.';
            }
        }
    }

    public boolean isSafe(char[][] board, int row, int col, int n) {

        // Check same column (above current row)
        for(int i = 0; i < row; i++) {
            if(board[i][col] == 'Q') {
                return false;
            }
        }

        // Check upper-left diagonal
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }

        // Check upper-right diagonal
        for(int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
}
