#
# @lc app=leetcode.cn id=70 lang=python3
#
# [70] 爬楼梯
#

# @lc code=start
class Solution:
    memory = {}
    def climbStairs(self, n: int) -> int:
        """
            递归解决:
            归纳条件: f(n) = f(n - 1) + f(n - 2)
            1. 退出条件: n <= 2 return n
            2. 加了一个缓存优化一下
        """
        if n <= 2:
            return n
        if n - 2 in Solution.memory:
            res1 = Solution.memory.get(n - 2)
        else:
            res1 = self.climbStairs(n - 2)
            Solution.memory[n - 2] = res1
        if n - 1 in Solution.memory:
            res2 = Solution.memory.get(n - 1)
        else:
            res2 = self.climbStairs(n - 1)
            Solution.memory[n - 1] = res2
        return res1 + res2
# @lc code=end

