#
# @lc app=leetcode.cn id=1 lang=python3
#
# [1] 两数之和
#

# @lc code=start
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        length = len(nums)
        for i, value in enumerate(nums):
            diff = target - value
            j = i + 1
            while j < length:
                if nums[j] == diff:
                    return (i, j)
                else:
                    j += 1
# @lc code=end

