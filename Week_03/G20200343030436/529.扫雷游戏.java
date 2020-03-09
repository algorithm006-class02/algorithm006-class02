/*
 * @lc app=leetcode.cn id=529 lang=java
 *
 * [529] 扫雷游戏
 */

// @lc code=start
class Solution {
    public char[][] updateBoard1(char[][] board, int[] click) {
        int m = board.length, n = board[0].length;
        int row = click[0], col = click[1];
        if (board[row][col] == 'M') {//很不幸 踩雷了的话 是雷直接 标注雷 退出
            board[row][col] = 'X';
        } else {//不是雷 那么先为了扫雷把棋盘隐藏的雷全部找出来统计出来数量
            //遍历这个棋盘 把所有是雷的地方全部扫描出来
            int count = 0;
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if (i == 0 && j == 0) {
                        continue;
                    }
                    int r = row + i;
                    int c = col + j;
                    if (r < 0 || r >= m || c < 0 || c >= n) {
                        continue;
                    }
                    if (board[r][c] == 'M' || board[r][c] == 'X') {
                        count++;
                    }
                }
            }
            if (count > 0) {//把点击的位置旁边到底有多少雷统计出来
                board[row][col] = (char) (count + '0');
            } else {//把点击的位置挖出来是空的，那么标注出来
                board[row][col] = 'B';
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        if (i == 0 && j == 0) {
                            continue;
                        }
                        int r = row + i, c = col + j;
                        if (r < 0 || r >= m || c < 0 || c >= n) {
                            continue;
                        }
                        if (board[r][c] == 'E') {
                            updateBoard(board, new int[]{r, c});
                        }
                    }
                }
            }
        }
        return board;
    }

    public char[][] updateBoard2(char[][] board, int[] click) {
        int m = board.length, n = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(click);
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0], col = cell[1];
            if (board[row][col] == 'M') {
                board[row][col] = 'X';
            } else {
                int count = 0;
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        if (i == 0 && j == 0) {
                            continue;
                        }
                        int r = row + i, c = col + j;
                        if (r < 0 || r >= m || c < 0 || c >= n) {
                            continue;
                        }
                        if (board[r][c] == 'M' || board[r][c] == 'X') {
                            count++;
                        }
                    }
                }
                if (count > 0) {
                    board[row][col] = (char) (count + '0');
                } else {
                    board[row][col] = 'B';
                    for (int i = -1; i < 2; i++) {
                        for (int j = -1; j < 2; j++) {
                            if (i == 0 && j == 0) {
                                continue;
                            }
                            int r = row + i, c = col + j;
                            if (r < 0 || r >= m || c < 0 || c >= n) {
                                continue;
                            }
                            if (board[r][c] == 'E') {
                                queue.add(new int[]{r, c});
                                board[r][c] = 'B';
                            }
                        }
                    }
                }
            }
        }
        return board;
    }
}
// @lc code=end

