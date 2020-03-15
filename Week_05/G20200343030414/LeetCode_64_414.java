package Week_05.G20200343030414;

/**
 * @author Xinshuai
 * @description 题目链接：https://leetcode-cn.com/problems/triangle/discuss/38735/Python-easy-to-understand-solutions-(top-down-bottom-up)/?utm_source=LCUS&utm_medium=ip_redirect_q_uns&utm_campaign=transfer2china
 * @since 2020-03-15 15:29
 */
public class LeetCode_64_414 {

    /**
     * 重复子问题：Math.min(从最后一个元素向上走一个元素的子问题, 从最后一个元素向左走一个元素的子问题)
     * 状态定义：int dp[][]
     * DP方程：dp[i][j] = grid[i][j] + math.min(dp[i+1][j], dp[i][j+1])
     * <p>
     *     时间复杂度：O(mn)
     *     空间复杂度：0(mn)
     */
    public int minPathSum1(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = grid.length - 1; i >= 0; i--) { // 行
            for (int j = grid[0].length - 1; j >= 0; j--) { // 列
                if (i == grid.length - 1 && j != grid[0].length - 1) {
                    dp[i][j] = grid[i][j] + dp[i][j + 1];
                } else if (i != grid.length - 1 && j == grid[0].length - 1) {
                    dp[i][j] = grid[i][j] + dp[i + 1][j];
                } else if (i != grid.length - 1 && j != grid[0].length - 1) {
                    dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
                } else {
                    dp[i][j] = grid[i][j];
                }
            }
        }
        return dp[0][0];
    }

    /**
     * 重复子问题：Math.min(从最后一个元素向上走一个元素的子问题, 从最后一个元素向左走一个元素的子问题)
     * 状态定义：int grid[][]
     * DP方程：grid[i][j] = grid[i][j] + math.min(grid[i+1][j], grid[i][j+1])
     * <p>
     *     时间复杂度：O(mn)
     *     空间复杂度：0(1)
     */
    public int minPathSum2(int[][] grid) {
        for (int i = grid.length - 1; i >= 0; i--) { // 行
            for (int j = grid[0].length - 1; j >= 0; j--) { // 列
                if (i == grid.length - 1 && j != grid[0].length - 1) {
                    grid[i][j] = grid[i][j] + grid[i][j + 1];
                } else if (i != grid.length - 1 && j == grid[0].length - 1) {
                    grid[i][j] = grid[i][j] + grid[i + 1][j];
                } else if (i != grid.length - 1 && j != grid[0].length - 1) {
                    grid[i][j] = grid[i][j] + Math.min(grid[i + 1][j], grid[i][j + 1]);
                } else {
                    grid[i][j] = grid[i][j];
                }
            }
        }
        return grid[0][0];
    }

    /**
     * 重复子问题：Math.min(从最后一个元素向上走一个元素的子问题, 从最后一个元素向左走一个元素的子问题)
     * 状态定义：int dp[]
     * DP方程：dp[j] = grid[i][j] + math.min(dp[j], dp[j+1])
     * <p>
     *     时间复杂度：O(mn)
     *     空间复杂度：0(mn)
     */
    public int minPathSum3(int[][] grid) {
        int[] dp = new int[grid[0].length];
        for (int i = grid.length - 1; i >= 0; i--) { // 行
            for (int j = grid[0].length - 1; j >= 0; j--) { // 列
                if (i == grid.length - 1 && j != grid[0].length - 1) {
                    dp[j] = grid[i][j] + dp[j + 1];
                } else if (i != grid.length - 1 && j == grid[0].length - 1) {
                    dp[j] = grid[i][j] + dp[j];
                } else if (i != grid.length - 1 && j != grid[0].length - 1) {
                    dp[j] = grid[i][j] + Math.min(dp[j], dp[j + 1]);
                } else {
                    dp[j] = grid[i][j];
                }
            }
        }
        return dp[0];
    }

}
