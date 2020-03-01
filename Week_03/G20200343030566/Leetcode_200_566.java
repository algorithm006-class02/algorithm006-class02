package com.sebar.test.leetcode.three.homework;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liguang
 * @Date 2020/2/28
 * @Description 200. 岛屿数量
 * https://leetcode-cn.com/problems/number-of-islands/
 */

public class Leetcode_200_566 {
    public static void main(String[] args) {
        Leetcode_200_566 code = new Leetcode_200_566();
        char[][] matrix = new char[4][5];
        matrix[0][0] = '1';
        matrix[0][1] = '1';
        matrix[0][2] = '1';
        matrix[0][3] = '1';
        matrix[0][4] = '0';
        matrix[1][0] = '1';
        matrix[1][1] = '1';
        matrix[1][2] = '0';
        matrix[1][3] = '1';
        matrix[1][4] = '1';
        matrix[2][0] = '1';
        matrix[2][1] = '1';
        matrix[2][2] = '0';
        matrix[2][3] = '0';
        matrix[2][4] = '0';
        matrix[3][0] = '0';
        matrix[3][1] = '0';
        matrix[3][2] = '0';
        matrix[3][3] = '0';
        matrix[3][4] = '0';
        int i = code.numIslands(matrix);
        System.out.println("岛屿数量：" + i);
    }

    /**
     * 深度优先搜索。以1位根节点，向左和向下进行拓展，碰到0则结束
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        // 行数-决定了向下的根探下的极限
        int row = grid.length;
        // 列数
        int col = grid[0].length;
        // 初始化岛屿数量
        int numIsLand = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 1是岛屿的开始节点
                if (grid[i][j] == '1') {
                    ++numIsLand;
                    dfs(grid, i, j);
                }
            }
        }
        return numIsLand;
    }

    /**
     * @param grid   二维数组
     * @param nowRow 当前行
     * @param nowCol 当前列
     */
    private void dfs(char[][] grid, int nowRow, int nowCol) {
        // 行数-决定了向下的根探下的极限
        int gridRow = grid.length;
        // 列数
        int gridCol = grid[0].length;

        // 中止条件 recursive terminator
        if (nowCol < 0 || nowRow < 0 || nowCol > gridCol || nowRow > gridRow || grid[nowRow][nowCol] == '0') {
            return;
        }
        // drill down
        // 将当前位置变为0
        grid[nowRow][nowCol] = '0';
        // 向上拓展
//        dfs(grid, nowRow - 1, nowCol);
        // 向下拓展
        dfs(grid, nowRow + 1, nowCol);
        // 向左拓展
//        dfs(grid, nowRow, nowCol - 1);
        // 向右拓展
        dfs(grid, nowRow, nowCol + 1);
        // reverse current status
    }

    public int numIsLandsBFS(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        // 行和列
        int row = grid.length;
        int col = grid[0].length;

        int numIsLands = 0;

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (grid[r][c] == '1') {
                    ++numIsLands;
                    // 将这个位置变为0 标记成已经访问过了
                    grid[r][c] = '0';
                    //
                    Queue<Integer> queue = new LinkedList<>();
                    // 将当前位置的下方节点加入到栈中，也就是下一列的第一个元素
                    queue.add(r * col + c);

                    while (!queue.isEmpty()) {
                        Integer index = queue.remove();
                        Integer nowRow = index / col;
                        Integer nowCol = index % col;

                        if (nowRow - 1 >= 0 && grid[nowRow - 1][nowCol] == '1') {
                            queue.add((nowRow - 1) * col + nowCol);
                            grid[nowRow - 1][nowCol] = '0';
                        }

                        if (nowRow + 1 < row && grid[nowRow + 1][nowCol] == '1') {
                            queue.add((nowRow + 1) * col + nowCol);
                            grid[nowRow + 1][nowCol] = '0';
                        }

                        if (nowCol - 1 >= 0 && grid[nowRow][nowCol - 1] == '1') {
                            queue.add(nowRow * col + nowCol - 1);
                            grid[nowRow][nowCol - 1] = '0';
                        }

                        if (nowCol + 1 < row && grid[nowRow][nowCol + 1] == '1') {
                            queue.add(nowRow * col + nowCol + 1);
                            grid[nowRow][nowCol + 1] = '0';
                        }
                    }
                }

            }
        }
        return 0;
    }
}


