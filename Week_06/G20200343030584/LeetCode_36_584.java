package week6;

import java.util.HashMap;
import java.util.Map;

/**
 * 36. 有效的数独
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * <p>
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * <p>
 * 说明:
 * <p>
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 给定数独序列只包含数字 1-9 和字符 '.' 。
 * 给定数独永远是 9x9 形式的。
 * <p>
 * 链接：https://leetcode-cn.com/problems/valid-sudoku
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        // 直接暴力遍历，对每个数字在其行、列、9宫格中验证是否有效
        // Map缓存法 - 每行、列、9宫格都分别对应一个map
        int length = board.length;
        Map<Integer, Integer>[] rows = new HashMap[length];
        Map<Integer, Integer>[] cols = new HashMap[length];
        Map<Integer, Integer>[] grid = new HashMap[length];
        for (int i = 0; i < length; i++) {
            rows[i] = new HashMap(length);
            cols[i] = new HashMap(length);
            grid[i] = new HashMap(length);
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                char num = board[i][j];
                if (num == '.') continue;
                int numInt = num;

                int gridIndex = (i / 3) * 3 + j / 3;
                if (rows[i].containsKey(numInt) || cols[j].containsKey(numInt) || grid[gridIndex].containsKey(numInt))
                    return false;

                rows[i].put(numInt, 1);
                cols[j].put(numInt, 1);
                grid[gridIndex].put(numInt, 1);
            }
        }
        return true;
    }

    public boolean isValidSudoku2(char[][] board) {
        // 数组缓存法
        // 充分利用只有1-9这些数字，把它们作为数组的下标，如果取出为1，说明已经用过了
        int length = board.length;
        int[][] rows = new int[length][length + 1];
        int[][] cols = new int[length][length + 1];
        int[][] grid = new int[length][length + 1];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                char num = board[i][j];
                if (num == '.') continue;
                int numInt = num - '0';

                int gridIndex = (i / 3) * 3 + j / 3;
                if (rows[i][numInt] == 1 || cols[j][numInt] == 1 || grid[gridIndex][numInt] == 1) return false;

                rows[i][numInt] = 1;
                cols[j][numInt] = 1;
                grid[gridIndex][numInt] = 1;
            }
        }
        return true;
    }
}
