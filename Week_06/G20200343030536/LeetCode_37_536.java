/**
 * https://leetcode-cn.com/problems/sudoku-solver/#/description
 * @author : Hyuk
 * @description : LeetCode_37_536
 * @date : 2020/3/22 8:35 下午
 */
public class LeetCode_37_536 {

    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) { return; }
        dfs(board);
    }

    private boolean dfs(char[][] board) {
        for (int i = 0, m = board.length; i < m ;++i) {
            for (int j = 0, n = board[0].length; j < n; ++j) {
                if (board[i][j] == '.') {
                    for (char k = '1'; k <= '9'; ++k) {
                        if (valid(board, i, j, k)) {
                            board[i][j] = k;
                            if (dfs(board)) { return true; }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean valid(char[][] board, int i, int j, char ch) {
        for (int k = 0; k < 9; ++k) {
            if (board[i][k] == ch) {
                return false;
            }
            if (board[k][j] == ch) {
                return false;
            }
            int r = 3 * (i / 3) + k / 3;
            int c = 3 * (j / 3) + k % 3;
            if (board[r][c] == ch) {
                return false;
            }
        }
        return true;
    }
}
