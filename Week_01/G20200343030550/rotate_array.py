# -*- encoding: utf-8 -*-

#暴力破解：超时
def rotateArr(nums,k):
    for i in xrange(k):
        pre = nums[len(nums) - 1]
        for j in xrange(len(nums)):
            temp = nums[j]
            nums[j] = pre
            pre = temp
    return nums





