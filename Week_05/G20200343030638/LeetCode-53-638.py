class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        n = len(nums)
        # 状态初始化，数组中第一个元素的最大和就是第一个元素值
        max_sum = nums[0]
        for i in range(1, n):
            # 状态转移方程
            nums[i] += max(nums[i - 1], 0)
            # 更新最大和
            max_sum = max(nums[i], max_sum)
        
        return max_sum