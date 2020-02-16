# -*- encoding: utf-8 -*-

def twoSum(nums,target):
    if len(nums) < 2:
        return False
    for i in xrange(len(nums)):
        for j in xrange(i+1,len(nums)):
            if nums[i] + nums[j] == target:
                return [i, j]