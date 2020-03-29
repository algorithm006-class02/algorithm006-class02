class Solution:
    def numSubarrayProductLessThanK(self, nums: List[int], k: int) -> int:
        # 定义状态数组: dp_product[i]表示 以i位置为结尾的连续子序列的乘积, dp[i]表示以i位置为结尾的连续子序列的乘积小于k的个数
        # 定义状态方程: dp[i] = dp[i - 1] + 

        dp_product = dp = nums
        dp[0] = 1 if nums[0] < k else 0

        for i in range(1, len(nums)):
            
            dp[i] = dp[i - 1] * nums[i]
        return dp[-1]