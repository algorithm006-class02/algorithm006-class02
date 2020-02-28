class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int in = board.length;
        int jn = board[0].length;
        updateBoard(board, click[0], click[1], in, jn);
        return board;
    }

    private void updateBoard(char[][] board, int i, int j, int in, int jn) {
        if (i < 0 || i >= in || j < 0 || j >= jn) {
            return;
        }
        char c = board[i][j];
        switch (c) {
            case 'E':
                int countMine = countMine(board, i, j, in, jn);
                if (countMine > 0) {
                    board[i][j] = (char) (48 + countMine);
                } else {
                    board[i][j] = 'B';
                    updateBoard(board, i - 1, j, in, jn);
                    updateBoard(board, i - 1, j - 1, in, jn);
                    updateBoard(board, i - 1, j + 1, in, jn);
                    updateBoard(board, i, j - 1, in, jn);
                    updateBoard(board, i, j + 1, in, jn);
                    updateBoard(board, i + 1, j, in, jn);
                    updateBoard(board, i + 1, j - 1, in, jn);
                    updateBoard(board, i + 1, j + 1, in, jn);
                }
                break;
            case 'M':
                board[i][j] = 'X';
                break;
        }
    }

    private int countMine(char[][] board, int i, int j, int in, int jn) {
        int count = 0;
        count += isMine(board, i - 1, j, in, jn);
        count += isMine(board, i - 1, j - 1, in, jn);
        count += isMine(board, i - 1, j + 1, in, jn);
        count += isMine(board, i, j - 1, in, jn);
        count += isMine(board, i, j + 1, in, jn);
        count += isMine(board, i + 1, j, in, jn);
        count += isMine(board, i + 1, j - 1, in, jn);
        count += isMine(board, i + 1, j + 1, in, jn);
        return count;
    }

    private int isMine(char[][] board, int i, int j, int in, int jn) {
        if (i < 0 || i >= in || j < 0 || j >= jn) {
            return 0;
        }
        if (board[i][j] == 'M') {
            return 1;
        } else {
            return 0;
        }
    }
}
