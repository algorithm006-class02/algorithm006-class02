using System;
using System.Collections.Generic;
using System.Text;

namespace Test
{
    public class LeetCode_221_560
    {
        public int maximalSquare(char[][] matrix)
        {
            if (matrix == null || matrix.Length < 1 || matrix[0].Length < 1) return 0;

            int height = matrix.Length;
            int width = matrix[0].Length;
            int maxSide = 0;

            int[,] dp = new int[height + 1, width + 1];

            for (int row = 0; row < height; row++)
            {
                for (int col = 0; col < width; col++)
                {
                    if (matrix[row][col] == '1')
                    {
                        dp[row + 1, col + 1] = Math.Min(Math.Min(dp[row + 1, col], dp[row, col + 1]), dp[row, col]) + 1;
                        maxSide = Math.Max(maxSide, dp[row + 1, col + 1]);
                    }
                }
            }
            return maxSide * maxSide;

        }
    }
}
