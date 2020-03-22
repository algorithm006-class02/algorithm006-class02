# -*- coding: utf-8 -*-
"""
72. 编辑距离
DP思路：
word1[i] = word2[i]： D[i][j]=1+min(D[i−1][j],D[i][j−1],D[i−1][j−1]−1)
word1[i] != word2[i] 替换最后一个字符使得他们相同：
D[i][j]=1+min(D[i−1][j],D[i][j−1],D[i−1][j−1])
"""

class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        m_len = len(word1)
        n_len = len(word2)

        if m_len == 0 and n_len == 0:
            return 0
        elif m_len == 0 or n_len == 0:
            return max(m_len, n_len)
        
        dp = [[0 for j in range(n_len+1)] for i in range(m_len+1)]
        for i in range(m_len+1):
            dp[i][0] = i
        for j in range(n_len+1):
            dp[0][j] = j

        for i in range(1, m_len+1):
            for j in range(1, n_len+1):
                if word1[i-1] == word2[j-1]:
                    dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]-1) + 1
                else:
                    dp[i][j] = 1+ min(dp[i-1][j],dp[i][j-1], dp[i-1][j-1])
        print(dp)
        return dp[m_len][n_len]