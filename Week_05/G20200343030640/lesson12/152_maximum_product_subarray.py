# -*- coding: utf-8 -*-
"""
152. 乘积最大子序列
DP思想
最大，最小值都有保留

"""

class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        ans = nums[0]
        imax, imin = 1, 1
        for i in range(len(nums)):
            if nums[i] < 0:
                imax, imin = imin, imax
            imax = max(imax*nums[i], nums[i])
            imin = min(imin*nums[i], nums[i])
            ans = max(imax, ans)

        return ans