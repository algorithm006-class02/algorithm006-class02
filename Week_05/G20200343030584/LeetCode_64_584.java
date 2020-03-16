package week5;

/**
 * 64. 最小路径和
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * 示例:
 * 输入:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 * <p>
 * https://leetcode-cn.com/problems/minimum-path-sum/
 */
public class MinPathSum {
    public static void test() {
        int[][] grid = {{1, 3, 4, 8}, {3, 2, 2, 4}, {5, 7, 1, 9}, {2, 3, 2, 3}};
        System.out.println("路径总和：" + new MinPathSum().minPathSum4(grid));
    }

    public int minPathSum(int[][] grid) {
        return helper(0, 0, grid);
    }

    private int helper(int row, int col, int[][] grid) {
        // 递归，自顶向下，从左到右，暴力求解
        if (row == grid.length || col == grid[0].length) {
            return Integer.MAX_VALUE;
        }
        if (row == grid.length - 1 && col == grid[0].length - 1)
            return grid[row][col];

        return grid[row][col] + Math.min(helper(row + 1, col, grid), helper(row, col + 1, grid));
    }


    public int minPathSum2(int[][] grid) {
        // 二维数组，自底向上,从右到左
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                if (i == rows - 1 && j == cols - 1) {
                    dp[i][j] = grid[i][j];
                } else if (i == rows - 1) {
                    dp[i][j] = grid[i][j] + dp[i][j + 1];
                } else if (j == cols - 1) {
                    dp[i][j] = grid[i][j] + dp[i + 1][j];
                } else {
                    dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[0][0];
    }

    public int minPathSum3(int[][] grid) {
        // 一维数组，自底向上,从右到左
        int rows = grid.length;
        int cols = grid[0].length;
        int[] dp = new int[cols];
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                if (i == rows - 1 && j == cols - 1) {
                    dp[j] = grid[i][j];
                } else if (i == rows - 1) {
                    dp[j] = grid[i][j] + dp[j + 1];
                } else if (j == cols - 1) {
                    dp[j] = grid[i][j] + dp[j];
                } else {
                    dp[j] = grid[i][j] + Math.min(dp[j], dp[j + 1]);
                }
            }
        }
        return dp[0];
    }

    public int minPathSum4(int[][] grid) {
        // 动态规划 - 不需要用额外的 dp 数组，而是在原数组上存储，将导致原数组被覆盖
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                if (i == rows - 1 && j != cols - 1) {
                    grid[i][j] = grid[i][j] + grid[i][j + 1];
                } else if (j == cols - 1 && i != rows - 1) {
                    grid[i][j] = grid[i][j] + grid[i + 1][j];
                } else if (i != rows - 1 && j != cols - 1) {
                    grid[i][j] = grid[i][j] + Math.min(grid[i + 1][j], grid[i][j + 1]);
                }
            }
        }
        return grid[0][0];
    }
}