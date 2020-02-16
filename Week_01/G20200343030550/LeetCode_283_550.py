# -*- encoding: utf-8 -*-
def moveZeroes(nums):
    #records the position of "0"
    zero = 0
    for i in xrange(len(nums)):
        if nums[i] != 0:
            nums[i], nums[zero] = nums[zero], nums[i]
            zero += 1
    return nums
