package com.sebar.test.leetcode.five.homework;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/minimum-path-sum/
 * 64. 最小路径和
 */
public class Leetcode_64_566 {
    /**
     * can not solve some test example
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int height = grid.length;
        int startIndex = grid[0].length - 1;
        int maxStep = grid[height - 1][startIndex];

        //
        for (int i = height - 1; i >= 0; i--) {
            // left top
            if (startIndex == 0) {
                maxStep += grid[i - 1][startIndex];
            } else if (i == 0) {
                for (int j = startIndex; j > 0; j--) {
                    maxStep += grid[i][j - 1];
                }
            } else {
                maxStep += Math.min(grid[i - 1][startIndex], grid[i][startIndex - 1]);
            }
        }
        return maxStep;
    }

    public int minPathSum2(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length-1; j >= 0; j--) {
                if (i == grid.length - 1 && j != grid[0].length-1) {
                    dp[i][j] = grid[i][j] + dp[i][j + 1];
                } else if (i != grid.length - 1 && j == grid[0].length-1) {
                    dp[i][j] = grid[i][j] + dp[i + 1][j];
                } else if (i != grid.length - 1 && j != grid[0].length-1) {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + grid[i][j];
                } else {
                    dp[i][j] = grid[i][j];
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        Leetcode_64_566 coco = new Leetcode_64_566();

        int[][] grid = new int[3][3];
        grid[0][0] = 1;
        grid[0][1] = 3;
        grid[0][2] = 1;
        grid[1][0] = 1;
        grid[1][1] = 5;
        grid[1][2] = 1;
        grid[2][0] = 4;
        grid[2][1] = 2;
        grid[2][2] = 1;

        int i = coco.minPathSum(grid);
        System.out.println(i);
    }
}
