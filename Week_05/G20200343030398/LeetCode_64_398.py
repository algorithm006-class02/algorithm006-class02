# https://leetcode-cn.com/problems/minimum-path-sum/
# 最小路径和

from typing import List
import math
import pytest

# 解法一：暴力
class Solution1:
    def minPathSum(self, grid: List[List[int]]) -> int:
        def helper(curh, curw):
            if (0 == curh) and (0 == curw):
                return grid[0][0]
            if (-1 == curh) or (-1 == curw):
                return math.inf
            return (
                min(helper(curh - 1, curw), helper(curh, curw - 1)) + grid[curh][curw]
            )

        return helper(len(grid) - 1, len(grid[0]) - 1)


# 解法一：暴力
class Solution2:
    def minPathSum(self, grid: List[List[int]]) -> int:
        def helper(curh, curw):
            if (h == curh) or (w == curw):
                return math.inf
            if (h - 1 == curh) and (w - 1 == curw):
                return grid[curh][curw]
            return (
                min(helper(curh + 1, curw), helper(curh, curw + 1)) + grid[curh][curw]
            )

        h = len(grid)
        w = len(grid[0])
        return helper(0, 0)


# 解法二：二维动态规划
class Solution3:
    def minPathSum(self, grid: List[List[int]]) -> int:
        def helper(curh, curw):
            if (h == curh) or (w == curw):
                return math.inf
            if (h - 1 == curh) and (w - 1 == curw):
                dp[curh][curw] = grid[curh][curw]
            if None == dp[curh][curw]:
                dp[curh][curw] = grid[curh][curw] + min(
                    helper(curh + 1, curw), helper(curh, curw + 1)
                )
            return dp[curh][curw]

        h = len(grid)
        w = len(grid[0])
        dp = [[None for j in range(w)] for i in range(h)]
        helper(0, 0)
        return dp[0][0]


# 解法三：一维动态规划
class Solution4:
    def minPathSum(self, grid: List[List[int]]) -> int:
        h = len(grid)
        w = len(grid[0])
        dp = [0 for i in range(w)]
        for curh in range(h):
            for curw in range(w):
                if (0 == curh) and (0 == curw):
                    dp[curw] = grid[curh][curw]
                elif 0 == curh:
                    dp[curw] = dp[curw - 1] + grid[curh][curw]
                elif 0 == curw:
                    dp[curw] = dp[curw] + grid[curh][curw]
                else:
                    dp[curw] = grid[curh][curw] + min(dp[curw], dp[curw - 1])
        return dp[w - 1]


class TestSolution:
    demo = [[1, 3, 1], [1, 5, 1], [4, 2, 1]]

    def testSolution1(self):
        assert 7 == Solution1().minPathSum(self.demo)

    def testSolution2(self):
        assert 7 == Solution2().minPathSum(self.demo)

    def testSolution3(self):
        assert 7 == Solution3().minPathSum(self.demo)

    def testSolution4(self):
        assert 7 == Solution4().minPathSum(self.demo)
