//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//
// 说明：每次只能向下或者向右移动一步。
//
// 示例:
//
// 输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 7
//解释: 因为路径 1→3→1→1→1 的总和最小。
//
// Related Topics 数组 动态规划


class Solution64 {
    // 子问题
    // 状态数组 a[i][j]
    // 状态转移方程 a[i][j] = max(a[i+1][j], a[i][j+1]) + grid[i][j];
    // 结果 a[0][0]
    public int minPathSum(int[][] grid) {
        // 处理特殊情况
        if (grid.length == 0)
            return 0;
        else if (grid[0].length == 1) {
            int res = 0;

            for (int i = 0; i < grid.length; i++) {
                res += grid[i][0];
            }

            return res;
        }
        if (grid.length == 1) {
            int res = 0;

            for (int i = 0; i < grid[0].length; i++) {
                res += grid[0][i];
            }

            return res;
        }
        // 定义状态数组
        int m = grid.length;
        int n = grid[0].length;
        int[][] a = new int[m][n];
        // 初始化
        a[m - 1][n - 1] = grid[m - 1][n - 1];
        // 初始化最后一行
        for (int i = n - 2; i >= 0; i--) {
            a[m - 1][i] = a[m - 1][i + 1] + grid[m - 1][i];
        }
        // 初始化最后一列
        for (int i = m - 2; i >= 0; i--) {
            a[i][n - 1] = a[i + 1][n - 1] + grid[i][n - 1];
        }
        // 递推
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                a[i][j] = Math.min(a[i + 1][j], a[i][j + 1]) + grid[i][j];
            }
        }
        // 返回结果
        return a[0][0];
    }
}
