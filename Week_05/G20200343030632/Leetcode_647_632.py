class Solution:
    def countSubstrings(self, s: str) -> int:
        # 动态规划
        # 1. 状态数组dp[i][j]表示字符串s[0, i]的回文子串的个数
        # 2. 状态方程 dp[i] = (if isPalindromic(s[i]) ? 1 : 0) + dp[i - 1]

        dp = [0 for _ in range(len(s) + 1)]
        # 空字符串是回文
        dp[0] = 1
        # for i in range(1, len(s) + 1):
            # if s[i - 1] == 

        