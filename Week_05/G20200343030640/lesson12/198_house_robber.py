# -*- coding: utf-8 -*-
"""
198. 打家劫舍
DP思想:
a[i]: [0,i]个房子偷取的最大金额
DP方程: a[i] = max(a[i-1], a[i-2]+nums[i])
"""

class Solution:
    def rob(self, nums: List[int]) -> int:
        if not nums or len(nums) == 0:
            return 0
        if len(nums) == 1:
            return nums[0]
        
        a = [0 for _ in range(len(nums))]
        a[0] = nums[0]
        a[1] = max(nums[0], nums[1])

        for i in range(2, len(nums)):
            # a[i]: 偷第i房子的最大金额
            a[i] = max(a[i-1], a[i-2]+nums[i])
        
        print(a)
        return a[-1]


class Solution2:
    def rob(self, nums: List[int]) -> int:
        if not nums or len(nums) == 0:
            return 0

        preMax, currMax = 0, 0

        for num in nums:
            temp = currMax
            currMax = max(currMax, preMax+num)
            preMax = temp

        return currMax