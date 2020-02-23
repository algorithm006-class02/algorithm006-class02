class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """

        # 1. 暴力法
        # size = len(nums)
        # for i in range(size - 1):
        #     for j in range(i + 1, size):
        #         if nums[i] + nums[j] == target:
        #             return [i, j]

        # 2. 剪枝（？）
        # 没必要一次次地在整个区间寻找
        # 因为配合i的j要么在i前面，要么在i后面的区间
        # 本例以在i前面的区间为例
        size = len(nums)
        j = -1

        for i in range(size):
            temp = nums[:i]
            tar = target - nums[i]
            if tar in temp:
                j = temp.index(tar) # 选择在i前面的区间，方便计算j的index
                return [j, i]
            