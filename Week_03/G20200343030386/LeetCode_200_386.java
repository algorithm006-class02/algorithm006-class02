package com.example.leetCode.week3;


public class LeetCode_200_386 {
//给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设
//网格的四个边均被水包围。
//
// 示例 1:
//
// 输入:
//11110
//11010
//11000
//00000
//
//输出: 1
//
//
// 示例 2:
//
// 输入:
//11000
//11000
//00100
//00011
//
//输出: 3
//
// Related Topics 深度优先搜索 广度优先搜索 并查集

    private static int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private boolean[][] marked;
    private int rows;
    private int cols;
    private char[][] grid;

    public int numIslands(char[][] grid) {
        int row = grid.length;
        if (row == 0) {
            return 0;
        }
        int col = grid[0].length;
        this.rows = row;
        this.cols = col;
        this.marked = new boolean[row][col];
        this.grid = grid;
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && !marked[i][j]) {
                    count++;
                    dfs(i, j);
                }
            }
        }
        return count;
    }

    private void dfs(int row, int col) {
        marked[row][col] = true;
        for (int i = 0; i < 4; i++) {
            int newRow = row + directions[i][0];
            int newCol = col + directions[i][1];
            if (inArea(newRow, newCol) && grid[newRow][newCol] == '1' && !marked[newRow][newCol]) {
                dfs(newRow, newCol);
            }
        }
    }

    private boolean inArea(int row, int col) {
        if (row >= 0 && row < rows && col >= 0 && col < cols) {
            return true;
        }
        return false;
    }

}
