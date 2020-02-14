#!/bin/env/python
nums = [1,8,6,2,5,4,8,3,7]

def maxArea(nums):
    left = 0
    right = len(nums) - 1
    area = 0 
    while left < right:
        coun = min(nums[left], nums[right]) * (right - left)
        area = max(area, coun)
        if nums[left] < nums[right]:
            left += 1
        else:
            right -= 1

    return area

print(maxArea(nums))