import functools
class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        return self.longestCommonSubsequence_v1(text1, text2)
        # return self.longestCommonSubsequence_v2(text1, text2)

    def longestCommonSubsequence_v1(self, text1: str, text2: str) -> int:
        # 递归分治
        if not (text1 or text2):
            return 0
        
        return self.helper(len(text1) - 1, text1, len(text2) - 1, text2)
    @functools.lru_cache
    def helper(self, s1_index, s1, s2_index, s2):
        
        # terminated
        if s1_index < 0 or s2_index < 0:
            return 0

        if s1[s1_index] == s2[s2_index]:
            return self.helper(s1_index - 1, s1, s2_index - 1, s2) + 1
        else:
            return max(self.helper(s1_index - 1, s1, s2_index, s2), self.helper(s1_index, s1, s2_index - 1, s2))
        


    def longestCommonSubsequence_v2(self, text1: str, text2: str) -> int:
        # 动态规划
        # 1. 划分子问题: 要求s1, s2两个字符串的最长公共子序列
        # 2. 定义状态数组: dp[i][j] 为s1[1, i]和s2[1, j]的最长公共子序列的长度
        # 3. 定义状态方程: 
        #       if s1[i - 1] == s2[j - 1]: dp[i][j] = 1 + dp[i - 1][j - 1]
        #       if s1[i - 1] != s2[j - 1]: dp[i][j] = max(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1])

        m, n = len(text1), len(text2)
        
        # dp[i][0], dp[0][i] 表示空字符串与其他字符串的情况

        dp = [[0 for _ in range(n + 1)] for _ in range(m + 1)]

        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if text1[i - 1] == text2[j - 1]:
                    dp[i][j] = 1 + dp[i - 1][j - 1]
                else:
                    dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])

        return dp[-1][-1]

    