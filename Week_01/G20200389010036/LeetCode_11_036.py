# https://leetcode-cn.com/problems/container-with-most-water/submissions/

# class Solution:
#     def maxArea(self, height: List[int]) -> int:
#         l, r, res = 0, len(height) - 1, 0
#         while l < r:
#             h = min(height[l], height[r])
#             res, l, r = max(res, h * ( r-l )), l + ( height[l] == h ), r - ( height[r] == h )
#         return res

# class Solution:
#     def maxArea(self, height: List[int]) -> int:
#         L, R, width, res = 0, len(height) - 1, len(height) - 1, 0
#         for w in range(width, 0, -1):
#             if height[L] < height[R]:
#                 res, L = max(res, height[L] * w), L + 1
#             else:
#                 res, R = max(res, height[R] * w), R - 1
#         return res

class Solution:
    def maxArea(self, height: List[int]) -> int:
        i, j, res = 0, len(height) - 1, 0
        while i < j:
            if height[i] < height[j]:
                res = max(res, height[i] * (j - i))
                i += 1
            else:
                res = max(res, height[j] * (j - i))
                j -= 1
        return res
