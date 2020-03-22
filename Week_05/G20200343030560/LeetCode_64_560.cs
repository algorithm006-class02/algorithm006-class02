using System;
using System.Collections.Generic;
using System.Text;

namespace Test
{
    public class LeetCode_64_560
    {
        public int minPathSum(int[][] grid)
        {
            for (int i = 0; i < grid.Length; i++)
            {
                for (int j = 0; j < grid[0].Length; j++)
                {
                    if (i == 0 && j == 0) continue;
                    else if (i == 0) grid[i][j] = grid[i][j - 1] + grid[i][j];
                    else if (j == 0) grid[i][j] = grid[i - 1][j] + grid[i][j];
                    else grid[i][j] = Math.Min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }
            }
            return grid[grid.Length - 1][grid[0].Length - 1];
        }
    }
}
