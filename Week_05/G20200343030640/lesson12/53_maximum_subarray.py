# -*- coding: utf-8 -*-
"""
53. 最大子序和
DP思想
当前元素自身最大 或 当前元素加上之前序列后为最大
dp[i] = max(nums[i], nums[i]+dp[i-1])
"""

class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        """
        初始化最大和：maxSum = nums[0]
        dp[i-1]: nums[i]之前的元素和，
            若dp[i-1] > 0, dp[i]=dp[i-1]+nums[i] 可能为正增益
            若dp[i-1] <= 0, dp[i]=dp[i-1]+nums[i] 可能为负增益，故dp[i] = nums[i]
        maxSum= max(dp[i], maxSum)
        """
        dp = nums
        maxSum = nums[0]
        for i in range(1, len(nums)):
            if dp[i-1] > 0:
                dp[i] += dp[i-1]
            maxSum = max(dp[i], maxSum)

        print(dp)
        return maxSum

class Solution2:
    def maxSubArray(self, nums: List[int]) -> int:
        dp = nums
        for i in range(1, len(nums)):
            dp[i] = max(nums[i], nums[i]+dp[i-1])

        print(dp)
        return max(dp)