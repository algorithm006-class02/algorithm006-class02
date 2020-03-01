public class LeetCode_529_590 {

    private static final int[] dirs = new int[]{0, -1, 1};

    public char[][] updateBoard(char[][] board, int[] click) {
        int row = click[0];
        int col = click[1];
        char state = board[row][col];
        if (state == 'M') {
            board[row][col] = 'X';
        } else {
            updateCell(board, row, col);
        }
        return board;
    }

    private void updateCell(char[][] board, int row, int col) {
        if (!isValidCoords(board, row, col)) {
            return;
        }

        char state = board[row][col];
        if (state != 'E') {
            return;
        }

        char nextState = calcNextState(board, row, col);
        board[row][col] = nextState;
        if (nextState != 'B') {
            return;
        }

        for (int i = 0; i < dirs.length; i++) {
            for (int j = 0; j < dirs.length; j++) {
                if (!(i == 0 && j == 0)) { // exclude itself
                    updateCell(board, row + dirs[i], col + dirs[j]);
                }
            }
        }
    }

    private char calcNextState(char[][] board, int row, int col) {
        int mines = 0;
        for (int i = 0; i < dirs.length; i++) {
            for (int j = 0; j < dirs.length; j++) {
                int nextRow = row + dirs[i];
                int nextCol = col + dirs[j];
                if (!isValidCoords(board, nextRow, nextCol) || (i == 0 && j == 0)) {
                    continue;
                }
                if (board[nextRow][nextCol] == 'M')  {
                    mines++;
                }
            }
        }
        return mines == 0 ? 'B' : (char) (mines + '0');
    }

    private boolean isValidCoords(char[][] board, int row, int col) {
        return row >=0 && col >= 0 && row < board.length && col < board[0].length;
    }
}
