"""
300. 最长上升子序列
"""

class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        """
        dp[i] = max(dp[j])+1, nums[i] > nums[j] 且 (0 <= j < i)
        """
        N = len(nums)
        if N < 2:
            return N
        
        dp = [1] * N
        for i in range(1, N):
            for j in range(0, i):
                if nums[i] > nums[j]:
                    # 使用dp[i] 保存每次与dp[j]的最大值，节约一个存储空间
                    dp[i] = max(dp[i], dp[j]+1)

        return max(dp)
