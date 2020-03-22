package com.sebar.test.leetcode.six.practice;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/valid-sudoku/description/
 * 36. 有效的数独
 */
public class Leetcode_36_566 {
    /**
     * 验证数独
     * 数字 1-9 在每一行只能出现一次。
     * 数字 1-9 在每一列只能出现一次。
     * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer>[] cols = new HashMap[9];
        HashMap<Integer, Integer>[] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<>();
            cols[i] = new HashMap<>();
            boxes[i] = new HashMap<>();
        }

        // 验证数独组合
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                // 数字
                if (num != '.') {
                    int n = (int) num;
                    int box = (i / 3) * 3 + j / 3;

                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    cols[j].put(n, cols[j].getOrDefault(n, 0) + 1);
                    boxes[box].put(n, boxes[box].getOrDefault(n, 0) + 1);

                    if (rows[i].get(n) > 1 || cols[j].get(n) > 1 || boxes[box].get(n) > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
