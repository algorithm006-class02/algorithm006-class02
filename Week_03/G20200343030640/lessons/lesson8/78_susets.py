# -*- coding: utf-8 -*-
"""
78. 子集
给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
说明：解集不能包含重复的子集。
"""

# 递归(开始假设输出子集为空，每一步都向子集添加新的整数，并生成新的子集)
# 对子集遍历
class Solution:
    # nums: List[int]
    # return: List[List[int]]
    def subsets(self, nums):
        ans = [[]]
        if not nums:
            return ans
        
        for i in nums:
            ans += [item+[i] for item in ans]
        return ans

# 回溯+递归: 对nums元素遍历，向当前子集中添加元素，用过的元素不能再用，所以range(j+1,n)
class Solution2:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []
        n = len(nums)
        
        def helper(i, tmp):
            res.append(tmp)

            for j in range(i, n):
                helper(j+1, tmp+[nums[j]])

        helper(0, [])
        return res  
