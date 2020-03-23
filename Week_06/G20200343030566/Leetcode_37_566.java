package com.sebar.test.leetcode.six.practice;

/**
 * https://leetcode-cn.com/problems/sudoku-solver/#/description
 * 37. 解数独
 */
public class Leetcode_37_566 {
    boolean isFinished = false;
    boolean[][] rows = new boolean[9][9], cols = new boolean[9][9], boxes = new boolean[9][9];

    /**
     * 解决数独
     *
     * @param board
     */
    public void solveSudoku(char[][] board) {
        // 分别记录9行，9列，9个子数独中9个数字的使用状态，

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    rows[i][board[i][j] - '1'] = true;
                    cols[j][board[i][j] - '1'] = true;
                    boxes[(i / 3) * 3 + j / 3][board[i][j] - '1'] = true;
                }
            }
        }
        //深度优先都是
        dfs(board, 0, 0);
    }

    private void dfs(char[][] board, int row, int col) {
        if (row == 9) {
            isFinished = true;
            return;
        }
        if (board[row][col] != '.') {
            if (col == 8) {
                dfs(board, row + 1, 0);
            } else {
                dfs(board, row, col + 1);
            }
        } else {
            // 填入数字
            int boxBlock = (row / 3) * 3 + col / 3;
            for (int i = 0; i < 9; i++) {
                if (!rows[row][i] && cols[col][i] && boxes[boxBlock][i]) {
                    board[row][col] = (char) (i + '1');
                    rows[row][i] = true;
                    cols[col][i] = true;
                    boxes[boxBlock][i] = true;
                    if (col == 8) {
                        dfs(board, row + 1, 0);
                    } else {
                        dfs(board, row, col + 1);
                    }
                    // 状态回溯
                    if (!isFinished) {
                        board[row][col] = '.';
                        rows[row][i] = false;
                        cols[col][i] = false;
                        boxes[boxBlock][i] = false;
                    }
                }
            }
        }
    }
}
