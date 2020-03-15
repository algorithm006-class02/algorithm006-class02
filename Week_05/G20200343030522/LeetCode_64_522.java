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


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        List<Integer> paths = new ArrayList<>();
        minPathSum(grid, 0, 0, 0, paths);
        return paths.get(0);
    }

    private void minPathSum(int[][] grid, int row, int col, int count, List<Integer> paths) {
        count += grid[row][col];
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            if (paths.size() > 0 && paths.get(0) > count) {
                paths.clear();
            }
            paths.add(count);
            return;
        }
        if (row < grid.length - 1) {
            minPathSum(grid, row + 1, col, count, paths);
        }
        if (col < grid[0].length - 1) {
            minPathSum(grid, row, col + 1, count, paths);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
