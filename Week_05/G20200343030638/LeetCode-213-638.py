class Solution:
    def rob(self, nums: List[int]) -> int:
        def dp(nums: List[int]):
            cur_max, pre_max = 0, 0

            for num in nums:
                cur_max, pre_max = max(pre_max + num, cur_max), cur_max
            return cur_max
            
        return max(dp(nums[1:]), dp(nums[:len(nums)-1])) if len(nums) != 1 else nums[0]