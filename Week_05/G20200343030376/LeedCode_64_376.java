package com.example.lib;

/**
 * 所属项目:JavaProject
 * 所属类名:com.example.lib.LeedCode_64_376
 * 功能描述:
 * 创建作者:Virgo
 * 创建时间:2020/3/15
 */

public class LeedCode_64_376 {

    public int minPathSum(int[][] grid) {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(i == 0 && j == 0) continue;
                else if(i == 0)  grid[i][j] = grid[i][j - 1] + grid[i][j];
                else if(j == 0)  grid[i][j] = grid[i - 1][j] + grid[i][j];
                else grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

}
