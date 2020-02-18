# =====================================
# No.1 两数之和
# 解题思路：暴力破解
# =====================================
class Solution(object):
    def twoSum(self, nums, target):
        i=0
        j=i+1

        for i in range(len(nums)):
            for j in range(len(nums)):
                if (nums[i]+nums[j]==target) and (i != j):
                    return [i,j]