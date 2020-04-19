using System;
using System.Collections.Generic;
using System.Text;

namespace Test
{
   public class LeetCode_547_560
    {
        public void dfs(int[][] M, int[] visited, int i)
        {
            for (int j = 0; j < M.Length; j++)
            {
                if (M[i][j] == 1 && visited[j] == 0)
                {
                    visited[j] = 1;
                    dfs(M, visited, j);
                }
            }
        }
        public int FindCircleNum(int[][] M)
        {
            int[] visited = new int[M.Length];
            int count = 0;
            for (int i = 0; i < M.Length; i++)
            {
                if (visited[i] == 0)
                {
                    dfs(M, visited, i);
                    count++;
                }
            }
            return count;
        }
    }
}
