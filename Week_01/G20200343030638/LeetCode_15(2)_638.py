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

        for k in range(n-2):
            if nums[k] > 0:
                break
            if k > 0 and nums[k] == nums[k-1]:
                continue
            i, j = k + 1, n - 1
            while i < j:
                s = nums[k] + nums[i] + nums[j]
                if s < 0 :
                    i += 1
                    while i < j and nums[i] == nums[i-1]:
                        i += 1
                elif s > 0:
                    j -= 1
                    while i < j and nums[j] == nums[j+1]:
                        j -= 1
                else:
                    res.append([nums[k], nums[i], nums[j]])
                    i += 1
                    j -= 1

                    while i < j and nums[i] == nums[i-1]:
                        i += 1
                    
                    while i < j and nums[j] == nums[j+1]:
                        j -= 1

        return res