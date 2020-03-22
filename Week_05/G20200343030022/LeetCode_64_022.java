/**
 * @Author ：zhenghaoran.
 * @Description：64. 最小路径和
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

说明：每次只能向下或者向右移动一步。

示例:

输入:
[
  [1,3,1],
[1,5,1],
[4,2,1]
]
输出: 7
解释: 因为路径 1→3→1→1→1 的总和最小。
 */
public class LeetCode_64_022 {
    public static void main(String[] args) {
        LeetCode_64_022 l = new LeetCode_64_022();
        int[][] arr = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        l.minPathSum(arr);
    }

    /**
     * 空间复杂度O(n^2)
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        for(int i = 1;i < grid.length;i++)
            grid[i][0] = grid[i][0] +grid[i-1][0];

        for(int i = 1;i < grid[0].length;i++)
            grid[0][i] = grid[0][i] + grid[0][i-1];

        for(int i = 1;i < grid.length;i++){
            for(int j = 1;j < grid[0].length;j++){
                grid[i][j] = Math.min(grid[i-1][j],grid[i][j-1]) + grid[i][j];
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }

    /**
     * 比较简洁
     * @param grid
     * @return
     */
    public int minPathSum2(int[][] grid) {
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
