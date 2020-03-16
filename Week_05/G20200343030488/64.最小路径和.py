#
# @lc app=leetcode.cn id=64 lang=python
#
# [64] 最小路径和
#

# @lc code=start
class Solution(object):
    def minPathSum(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if i==j==0: continue
                elif i==0: grid[i][j] = grid[i][j-1]+grid[i][j]
                elif j==0: grid[i][j] = grid[i-1][j]+grid[i][j]
                else: grid[i][j] = min(grid[i-1][j],grid[i][j-1])+grid[i][j]
        return grid[-1][-1]



# @lc code=end

#         import sys
        
#         x = len(grid)
#         y = len(grid[0])

#         memo = [[-1]*y for _ in range(x)]
#         def curr(i,j):
            
#             if i==0 and j==0: return grid[0][0]
#             if i==-1 or j==-1: return sys.maxsize
#             if memo[i][j]==-1:
#                 memo[i][j] = grid[i][j]+min(curr(i-1,j),curr(i,j-1))
#             return memo[i][j]
#         res = curr(x-1,y-1)
#         return res


# s = Solution().minPathSum([[1,3,1],[1,5,1],[4,2,1]])