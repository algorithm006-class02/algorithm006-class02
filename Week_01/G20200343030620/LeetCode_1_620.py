class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        first = {}
        for idx, var in enumerate(nums):
            sub = target - var
            # if sub in nums and nums.index(sub)!=idx:
            #     return [idx, nums.index(sub)]
            # 使用dict 先将第一个减数存起来,同时dict 是hash 查找时间复杂度为o(1)
            if sub in first:
                return [first[sub], idx]
            first[var] = idx
