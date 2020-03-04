class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int row = click[0], col = click[1];
        if (board[row][col] == 'M') board[row][col] = 'X';
        else findAdjacentBlankNode(board, row, col);

        return board;
    }

    private void findAdjacentBlankNode(char[][] board, int row, int col) {
        int bRow = board.length;
        int bCol = board[0].length;

        int count = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                int r = row+i, c = col+j;

                if (r >= 0 && c >= 0 && r < bRow && c < bCol && board[r][c] == 'M') {
                    count++;
                }
            }
        }

        if (count > 0) {
            board[row][col] = (char)('0' + count);

        } else {

            board[row][col] = 'B';
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    int r = row+i, c = col+j;
                    if (r >= 0 && c >= 0 && r < bRow && c < bCol && board[r][c] == 'E') {
                        findAdjacentBlankNode(board, r, c);
                    }
                }
            }
        }
    }
}
