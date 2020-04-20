"""
91. 解码方法
dp[i]: s[0...i]解码方法数
s[i] == '0':
    s[i-1] == '1' or '2': dp[i] = dp[i-2], 因s[i-1]s[i]合在一起解码
s[i] == '1': s[i-1],s[i]可以合并解码，也可分开解码，dp[i]=dp[i-1]+dp[i-2]
s[i] == '2': 若s[i-1] 在['1', '6']之间，dp[i]=dp[i-1]+dp[i-2]
"""


class Solution:
    def numDecodings(self, s: str) -> int:
        if s[0] == '0': return 0

        pre, curr = 1, 1
        for i in range(1, len(s)):
            tmp = curr
            if s[i] == '0':
                if (s[i-1] == '1' or s[i-1] == '2'):
                    curr = pre
                else:
                    return 0
            else:
                if s[i-1] == '1' or (s[i-1] == '2' and '1' <= s[i] and s[i] <= '6'):
                    curr = curr + pre
            pre = tmp
        
        return curr