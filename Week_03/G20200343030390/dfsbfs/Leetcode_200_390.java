package com.subject.week03.dfsbfs;

/**
 *给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 * 示例 1:
 *
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * 输出: 1
 * 示例 2:
 *
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * 输出: 3
 *
 * 思路（精简）：
 *  dfs
 * 用一个嵌套的循环 循环每个元素；
 * 若元素为1 岛屿数量加1， 递归 把它及相邻的元素都置为0 (水平垂直方向 左右上下)--认为是1个岛屿；
 * 继续循环 直到循环到最末尾
 *
 *
 */


public class Leetcode_200_390 {

    private int n;
    private int m;

    public int numIslands(char[][] grid) {
        int count = 0;
        // 行数
        n = grid.length;
        if(n == 0) {
            return 0;
        }
        // 列数
        m = grid[0].length;
        for(int i = 0; i < n; i++ ) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid, int i, int j) {
        // 边界条件
        if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1' ){
            return;
        }
        grid[i][j] = '0';
        dfs(grid,i+1,j);
        dfs(grid,i,j+1);
        dfs(grid,i-1,j);
        dfs(grid,i,j-1);
    }

}