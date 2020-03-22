using System;
using System.Collections.Generic;
using System.Text;

namespace Test
{
    public class LeetCode_70_560
    {
        public int ClimbStairs(int n)
        {
            if (n == 1)
            {
                return 1;
            }
            int[] dp = new int[n + 1];
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i <= n; i++)
            {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
    }
}
