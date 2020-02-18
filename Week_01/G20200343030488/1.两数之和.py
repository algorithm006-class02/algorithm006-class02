#
# @lc app=leetcode.cn id=1 lang=python
#
# [1] 两数之和
#

# @lc code=start
class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        length = len(nums)
        for i in range(length-1):
            for j in range(i+1,length):
                if nums[i]+nums[j]==target:
                    return [i,j]

# @lc code=end

a = [3,2,4]
b = 6

c = Solution()
print(c.twoSum(a,b))