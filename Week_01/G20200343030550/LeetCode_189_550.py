# -*- encoding: utf-8 -*-

def rotate(self, nums, k):
    n = len(nums)
    k = k % n
    nums[:] = nums[n-k:] + nums[:n-k]
    return nums





