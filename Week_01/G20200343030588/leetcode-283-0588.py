#!/bin/env/python

class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        index = 0
        for i in range(len(nums)):
            if nums[i] == 0:
                index += 1
            else:
                nums[i - index] = nums[i]

        index0 = len(nums) - index
        while index0 <= len(nums) -1:
            nums[index0] = 0
            index0 +=1