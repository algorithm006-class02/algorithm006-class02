#
# @lc app=leetcode.cn id=91 lang=python
#
# [91] 解码方法
#

# @lc code=start
class Solution(object):
    def numDecodings(self, s):
        """
        :type s: str
        :rtype: int
        """
        size = len(s)
        #特判
        if size == 0:
            return 0
        dp = [0]*(size+1)
        dp[0] = 1 
        for i in range(1,size+1):
            t = int(s[i-1])
            if t>=1 and t<=9:
                dp[i] += dp[i-1] #最后一个数字解密成一个字母
            if i >=2:#下面这种情况至少要有两个字符
                t = int(s[i-2])*10 + int(s[i-1])
                if t>=10 and t<=26:
                    dp[i] += dp[i-2]#最后两个数字解密成一个一个字母
        return dp[-1]


print(Solution().numDecodings("10"))


# @lc code=end

