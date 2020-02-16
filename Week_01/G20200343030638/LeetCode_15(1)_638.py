#
# @lc app=leetcode.cn id=15 lang=python3
#
# [15] 三数之和
#

# @lc code=start
class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        res = []
        n = len(nums)
        nums.sort()

        for i in range(n-2):
            for j in range(i + 1, n-1):
                for k in range(j + 1, n):
                    if nums[i] + nums[j] + nums[k] == 0 and [nums[i],nums[j],nums[k]] not in res:
                        res.append([nums[i], nums[j], nums[k]])
        return res