# -*- encoding: utf8 -*-
"""
1、将列表元素转变为int整数：10^n*m+...
2、通过整数计算
3、将int-->字符串-->list
"""

def plusoOne(nums):
    res = 0
    for i in xrange(len(nums)):
        res += pow(10, len(nums) - 1 - i) * nums[i]
    return [int(i) for i in str(res + 1)]
