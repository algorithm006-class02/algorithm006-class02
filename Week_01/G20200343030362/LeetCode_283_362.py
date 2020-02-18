class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        loc = 0
        for i in range(len(nums)):
            if nums[i] != 0:
                nums[i], nums[loc] = nums[loc], nums[i]
                loc += 1
        return nums
