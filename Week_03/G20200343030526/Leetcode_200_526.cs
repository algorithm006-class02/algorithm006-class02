/*
 * @lc app=leetcode.cn id=200 lang=csharp
 *
 * [200] 岛屿数量
 *
 * https://leetcode-cn.com/problems/number-of-islands/description/
 *
 * algorithms
 * Medium (46.72%)
 * Likes:    392
 * Dislikes: 0
 * Total Accepted:    59.1K
 * Total Submissions: 125.4K
 * Testcase Example:  '[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]'
 *
 * 给定一个由 '1'（陆地）和
 * '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
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
 * 
 * 
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
 * 
 */

// @lc code=start
public class Solution
{
    public int NumIslands(char[][] grid)
    {
        //思路：遍历时，找到1了之后，把所有上下左右的1都访问一遍，并把已经访问过的设置为0
        //这样虽然仍然是循环M*N次，但只处理其中一部分内容
        //dfs的作用是提前把当前岛屿的剩余部分都标记已经访问
        //或者可以这么理解，识别一座岛屿后（遍历到岛屿的第一个‘1’，并计数）
        //然后把这座岛屿拿掉，全部变为水
        int count = 0;
        if (grid == null || grid.Length == 0) return 0;
        for (int r = 0; r < grid.Length; r++)
        {
            for (int c = 0; c < grid[r].Length; c++)
            {
                if (grid[r][c] == '1')
                {
                    count++;
                    dfs(grid, r, c);
                }
            }
        }
        return count;
    }

    void dfs(char[][] grid, int r, int c)
    {
        int rows = grid.Length;
        int cols = grid[0].Length;
        if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == '0') return;
        grid[r][c] = '0';
        dfs(grid, r + 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r - 1, c);
        dfs(grid, r, c - 1);
    }
}
// @lc code=end

