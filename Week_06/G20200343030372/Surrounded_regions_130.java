package G20200343030372;

/**
 * @author Chen.C
 * @date 2020/3/20
 */
public class Surrounded_regions_130 {

    public void solve(char[][] board) {
        int rows = board.length;
        if (rows == 0) {
            return;
        }
        int cols = board[0].length;
        for (int i = 0; i < cols; i++) {
            if (board[0][i] == 'O') {
                dfs(0, i, board);
            }
            if (board[board.length - 1][i] == 'O') {
                dfs(board.length - 1, i, board);
            }

        }
        for (int i = 1; i < rows - 1; i++) {
            if (board[i][0] == 'O') {
                dfs(i, 0, board);
            }
            if (board[i][board[0].length - 1] == 'O') {
                dfs(i, board[0].length - 1, board);
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                switch (board[i][j]) {
                    case '.':
                        board[i][j] = 'O';
                        break;
                    case 'O':
                        board[i][j] = 'X';
                        break;
                    default:
                }
            }
        }
    }

    private void dfs(int i, int j, char[][] board) {
        if (i < 0 || j < 0 || i == board.length || j == board[0].length) {
            return;
        }
        if (board[i][j] == '.') {
            return;
        }
        if (board[i][j] == 'O') {
            board[i][j] = '.';
            dfs(i + 1, j, board);
            dfs(i, j + 1, board);
            dfs(i, j - 1, board);
            dfs(i - 1, j, board);
        }
    }
}
