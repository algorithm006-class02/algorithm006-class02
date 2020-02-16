#
# @lc app=leetcode.cn id=1 lang=python3
#
# [1] 两数之和
#

# @lc code=start

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        res = {}
        for i, num in enumerate(nums):
            if num in res:
                return res[num], i
            else:
               res[target - num] = i
        return None
            

# @lc code=end
