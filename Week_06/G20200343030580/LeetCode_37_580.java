class Solution {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length < 9) {
            return;
        }
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    continue;
                }
                for (char c = '1'; c <= '9'; c++) {
                    if (isValidSudoku(board, i, j, c)) {
                        board[i][j] = c;
                        if (solve(board)) {
                            return true;
                        }
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board, int i, int j, char c) {
        for (int k = 0; k < 9; k++) {
            if (board[i][k] == c) {
                return false;
            }
            if (board[k][j] == c) {
                return false;
            }
            if (board[3 * (i / 3) + k / 3][3 * (j / 3) + k % 3] == c) {
                return false;
            }
        }
        return true;
    }
}
