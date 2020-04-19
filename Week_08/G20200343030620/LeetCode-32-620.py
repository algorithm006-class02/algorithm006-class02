class Solution:
    def longestValidParentheses(self, s: str) -> int:
        #思路1:暴力求解算法，时间复杂度为o(n^2)
        #思路2:动态规划求解1.寻找重复子问题 2. 定义状态存储数组 3.状态转移方程
        #if )  if s[i-1]=(  dp[i-2]+2  if s[i-1]=) 则需要进行剪枝,判断 s[i-1-dp[i-1]]( 则dp[i-1]+2+dp[i-dp[i-1]-2] 需要注意的是 i-dp[i-1]-2 可能会出现越界问题。 使用动态规划求解，时间复杂为o(n)
        lens=len(s)
        dp=[0 for _ in range(lens)]
        res=0
        for i in range(1,lens):
            if s[i]==')':
                if s[i-1]=='(':
                    dp[i]= dp[i-2]+2 if i-2>=0 else 2
                elif i-1-dp[i-1]>=0 and  s[i-1-dp[i-1]]=='(':
                        if i-2-dp[i-1]>=0 :
                            dp[i]=dp[i-1]+2+dp[i-2-dp[i-1]]
                        else:
                            dp[i]=dp[i-1]+2
            res=max(res,dp[i])
        return res 