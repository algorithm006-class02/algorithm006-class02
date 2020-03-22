#
# @lc app=leetcode.cn id=77 lang=python3
#
# [77] 组合
#

# @lc code=start
class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        if k == 0:
            return [[]]
        nums = [i for i in range(1, n + 1)]
        # if k == n:
            # return [[i for i in range(1, n + 1)]]
        res = []
        self.helper(nums, k, [], res)
        return res

    def helper(self, nums, k, current, res):
        # 退出条件以及结果处理
        if len(current) == k:
            res.append(current)
            return
        # 当前层处理
        for i, val in enumerate(nums):
            self.helper(nums[i + 1:], k, current + [val], res)
        
# @lc code=end

