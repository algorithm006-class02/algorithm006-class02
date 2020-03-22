def numDecodings(s):
    """
    :type s: str
    :rtype: int
    """
    size = len(s)
    if size == 0:
        return 0
    dp = [0]*(size+1)
    dp[0] = 1 
    for i in range(1,size+1):
        t = int(s[i-1])
        if t>=1 and t<=9:
            dp[i] += dp[i-1]
        if i >=2:
            t = int(s[i-2])*10 + int(s[i-1])
            if t>=10 and t<=26:
                dp[i] += dp[i-2]
    return dp[-1]