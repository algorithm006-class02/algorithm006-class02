"""
Linked: https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
Desc: 删除排序数组中的重复项
"""

class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        i = 0
        for idx, item in enumerate(nums):
            if nums[i] != item:
                i = i + 1
                nums[i] = item
    
        return i + 1