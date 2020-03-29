class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        # 动态规划
        # 1. 分治问题: 第i个元素为结尾的的最大连续子数组的和, max_sub(i) = Max(max_sub(i - 1), 0) + nums[i])
        # 2. 定义状态数组: dp[i] 表示第i个元素为结尾的的最大连续子数组的和
        # 3. 定义状态方程: dp[i] = Max(dp[i - 1], 0) + nums[i]

        dp = nums
        for i in range(1, len(dp)):
            dp[i] = max(dp[i - 1], 0) + nums[i]
        
        return max(dp)