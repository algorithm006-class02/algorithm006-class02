# https://leetcode-cn.com/problems/3sum/

# class Solution:
#     def climbStairs(self, n: int) -> int:
#         climb = {}
#         climb[0] = 0
#         climb[1] = 1
#         climb[2] = 2

#         for n in range(3, n+1):
#             climb[n] = climb[n-1] + climb[n-2]
        
#         return climb[n]

class Solution:
    def climbStairs(self, n: int) -> int:
        a, b = 1, 1
        for i in range(n):
            a, b = b, a + b
        return a

