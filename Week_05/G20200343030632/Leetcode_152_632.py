class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        # 动态规划
        # 1. 定义状态数组: dp[i]表示以i个位置为结尾的连续子序列 乘积最大的值
        # 2. 定义状态转移方程: dp[i] = max(dp[i - 1] * nums[i], nums[i])

        dp_min = dp_max = res = nums[0]

        for i in range(1, len(nums)):
            if nums[i] < 0:
                dp_min, dp_max = dp_max, dp_min
            
            dp_max = max(dp_max * nums[i], nums[i])
            dp_min = min(dp_min * nums[i], nums[i])
            res = max(dp_max, dp_min)
        return res
