class Solution:
    def subsets(self, nums):
        res = []
        self.helper(0, nums, [], res)
        return res
    def helper(self, nums, curpath, res):
        res.append(curpath)
        for i in range(len(nums)):
            self.helper(nums[i + 1:], curpath + [nums[i]], res)
    