# https://leetcode-cn.com/problems/move-zeroes/

class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        tail = 0
        for fast in range(len(nums)):
            if nums[fast] != 0:
                nums[tail], nums[fast] = nums[fast], nums[tail]
                tail += 1