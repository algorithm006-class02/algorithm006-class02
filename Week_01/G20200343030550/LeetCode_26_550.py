# -*- encoding: utf-8 -*-

def removeDuplicates(nums):
    if len(nums) == 0:
        return 0
    size = 0
    for i in xrange(1,len(nums)):
        if nums[i] != nums[size]:
            size += 1
            nums[size] = nums[i]
    return size + 1

