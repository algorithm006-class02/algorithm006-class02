package com.ping.leetcode.medium;

/**
 * @Author: 高一平
 * @Date: 2020/3/1
 * @Description: 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 示例:
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 **/
public class MinPathSum64 {
    public int minPathSum(int[][] grid) {
        return minPathSum1(grid);
    }

    /**
     * 暴力求解
     * 根据题意
     * grid[i][j] 的结果为 grid[i+1][j] + grid[i][j+1] 的结果
     *
     * @param grid
     * @return
     */
    private int minPathSum1(int[][] grid) {
        int result = minPathSum1(grid, 0, 0);
        return result;
    }

    private int minPathSum1(int[][] grid, int i, int j) {
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        } else if (i == grid.length - 1) {
            return grid[i][j] + minPathSum1(grid, i, j + 1);
        } else if (j == grid[0].length - 1) {
            return grid[i][j] + minPathSum1(grid, i + 1, j);
        } else {
            return grid[i][j] + Math.min(minPathSum1(grid, i + 1, j), minPathSum1(grid, i, j + 1));
        }
    }

    /**
     * 二维数组，记录所有结果
     * 根据题意
     * grid[i][j] 的结果为 grid[i+1][j] + grid[i][j+1] 的结果
     *
     * @param grid
     * @return
     */
    private int minPathSum2(int[][] grid) {
        int[][] result = new int[grid.length][grid[0].length];
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (i == grid.length - 1 && j == grid[0].length - 1) {
                    result[i][j] = grid[i][j];
                } else if (i == grid.length - 1) {
                    result[i][j] = grid[i][j] + result[i][j + 1];
                } else if (j == grid[0].length - 1) {
                    result[i][j] = grid[i][j] + result[i + 1][j];
                } else {
                    result[i][j] = grid[i][j] + Math.min(result[i + 1][j], result[i][j + 1]);
                }
            }
        }
        return result[0][0];
    }

    private int minPathSum3(int[][] grid) {
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (i == grid.length - 1 && j == grid[0].length - 1) {
                    continue;
                } else if (i == grid.length - 1) {
                    grid[i][j] = grid[i][j] + grid[i][j + 1];
                } else if (j == grid[0].length - 1) {
                    grid[i][j] = grid[i][j] + grid[i + 1][j];
                } else {
                    grid[i][j] = grid[i][j] + Math.min(grid[i + 1][j], grid[i][j + 1]);
                }
            }
        }
        return grid[0][0];
    }

}
