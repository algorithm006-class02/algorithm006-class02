class Solution:
def numDecodings(self, s: str) -> int:
    n = len(s)
    if n == 0:
        return 0
    dp = [0 for x in range(n + 1)]
    
    # 初始化
    dp[0] = 1
    dp[1] = 0 if s[0] == "0" else 1
    for i in range(2, n + 1):
        c = int(s[i - 1])
        p = int(s[i - 2])
        if 0 < c <= 9:
            dp[i] += dp[i - 1]
        if p == 1 or (p == 2 and c <= 6):
            dp[i] += dp[i - 2]
    return dp[-1];
