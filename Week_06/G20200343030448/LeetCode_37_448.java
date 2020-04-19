package G20200343030448;

public class LeetCode_37_448 {
    public void solveSudoku(char[][] board) {
        //初始化布尔数组，记录数字是否被行、列、3x3宫格使用。
        boolean[][] rowUsedMark = new boolean[9][10];
        boolean[][] colUsedMark = new boolean[9][10];
        boolean[][] boxUsedMark = new boolean[9][10];
        //初始化数字使用情况
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] != '.') {
                    int num = (int) board[row][col] - 48;
                    int boxindex = (row / 3) * 3 + (col / 3);
                    rowUsedMark[row][num] = true;
                    colUsedMark[col][num] = true;
                    boxUsedMark[boxindex][num] = true;
                }
            }
        }
        //回溯递归方式填充数组
        recursiveSolveSodoku(board, rowUsedMark, colUsedMark, boxUsedMark, 0, 0);
    }

    private boolean recursiveSolveSodoku(char[][] board, boolean[][] rowUsedMark, boolean[][] colUsedMark, boolean[][] boxUsedMark, int row, int col) {
        //如果一行完成，col清零row++，换行
        if (col == 9) {
            col = 0;
            row++;
            //如果col和row都到了尽头返回true，结束递归。
            if (row == 9) {
                return true;
            }
        }
        //如果是空，就尝试填数。否则直接跳下一个位置。
        if (board[row][col] == '.') {
            //尝试填充0-9
            for (int number = 1; number < 10; number++) {
                //先判断是否可用
                int boxindex = (row / 3) * 3 + (col / 3);
                if (!(rowUsedMark[row][number] || colUsedMark[col][number] || boxUsedMark[boxindex][number])) {
                    rowUsedMark[row][number] = true;
                    colUsedMark[col][number] = true;
                    boxUsedMark[boxindex][number] = true;
                    board[row][col] = (char) ('0' + number);
                    if (recursiveSolveSodoku(board, rowUsedMark, colUsedMark, boxUsedMark, row, col + 1)) {
                        return true; //如果正解，应该是一路true回复上层递归。
                    }
                    //如果上面的数字判失败，开始回滚操作
                    board[row][col] = '.';
                    rowUsedMark[row][number] = false;
                    colUsedMark[col][number] = false;
                    boxUsedMark[boxindex][number] = false;
                }
            }
        } else {
            return recursiveSolveSodoku(board, rowUsedMark, colUsedMark, boxUsedMark, row, col + 1);
        }
        return false;//填错需要回溯的时候用的false
    }
}
