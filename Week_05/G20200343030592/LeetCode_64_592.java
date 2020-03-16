package com.gsf.geekbang_demo.arithmetic.leetCode.week05;

/**
 * 64. 最小路径和
 */
public class Demo64 {

    //方法一
//    public int minPathSum(int[][] grid) {
//        int[][] res = new int[grid.length][grid[0].length];
//        for (int i = grid.length - 1; i >= 0; i--) {
//            for (int j = grid[i].length - 1; j >= 0; j--) {
//                if (i == grid.length - 1 && j != grid[0].length - 1) {
//                    res[i][j] = res[i][j + 1] + grid[i][j];
//                } else if (i != grid.length - 1 && j == grid[0].length - 1) {
//                    res[i][j] = res[i + 1][j] + grid[i][j];
//                } else if (i != grid.length - 1 && j != grid[0].length - 1) {
//                    res[i][j] = Math.min(res[i + 1][j], res[i][j + 1]) + grid[i][j];
//                } else {
//                    res[i][j] = grid[i][j];
//                }
//            }
//        }
//        return res[0][0];
//    }

    //方法二
//    public int minPathSum(int[][] grid) {
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[i].length; j++) {
//                if (i == 0 && j != 0) grid[i][j] += grid[i][j - 1];
//                if (i != 0 && j == 0) grid[i][j] += grid[i - 1][j];
//                if (i != 0 && j != 0) grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
//            }
//        }
//        return grid[grid.length - 1][grid[0].length - 1];
//    }

    //方法三
    public int minPathSum(int[][] grid) {
        int[] dp = new int[grid.length];
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[i].length - 1; j >= 0; j--) {
                if (i != grid.length - 1 && j == grid[0].length - 1) {
                    dp[j] = grid[i][j] + dp[j];
                } else if (i == grid.length - 1 && j != grid[0].length - 1) {
                    dp[j] = grid[i][j] + dp[j + 1];
                } else if (i != grid.length - 1 && j != grid[0].length - 1) {
                    dp[j] = grid[i][j] + Math.min(dp[j], dp[j + 1]);
                } else {
                    dp[j] = grid[i][j];
                }
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        System.err.println(new Demo64().minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
    }
}


// dp
// 1.最优子结构(子问题) problem[i,j] = min(grid[i+1][j], grid[i][j+1]) + grid[i][j]
// 2.状态定义 f[i][j]
// 3.dp方程 f[i,j] = min(grid[i+1][j], grid[i][j+1]) + grid[i][j]