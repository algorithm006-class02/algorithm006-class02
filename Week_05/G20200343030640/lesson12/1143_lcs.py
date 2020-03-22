# -*- coding: utf-8 -*-
"""
1143. 最长公共子序列LCS
bottom-up 递推：
strA: "abc" -> "...c"
strB: "efc" -> "...c"
即转化为: "ab"和"ef"的 lcs, 然后 + 1
"""

class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        if len(text1) == 0 or len(text2) == 0:
            return 0
        R = len(text1)
        C = len(text2)

        dp = [[0 for j in range(C+1)] for i in range(R+1)]
        
        # self.LCS(R, C , dp)
        # dp[0][0] = 1 if text1[0] == text2[0] else 0

        # for i in range(1, R):
        #     if text1[i] == text2[0]:
        #         dp[i][0] = dp[i-1][0] + 1
        #     else:
        #         dp[i][0] = dp[i-1][0]

        # for j in range(1, C):
        #     if text1[0] == text2[j]:
        #         dp[0][j] = dp[0][j-1] + 1
        #     else:
        #         dp[0][j] = dp[0][j-1]

        for i in range(1, R+1):
            for j in range(1, C+1):
                if text1[i-1] == text2[j-1]:
                    dp[i][j] = dp[i-1][j-1] +1
                else:
                    dp[i][j] = max(dp[i-1][j], dp[i][j-1])
        
        # print(dp)
        return dp[R][C]
