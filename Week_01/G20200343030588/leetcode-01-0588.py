#!/bin/env/python

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        for i in range(len(nums)):
            temp = nums[:i]
            if target - nums[i] in temp:
                res = temp.index(target - nums[i])
                break
        return [res,i]