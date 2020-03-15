class Solution(object):
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        # 首先遍历 遇到非0则和前一位兑换， 0逐步后移，
        # 记录 当前第一个0的位置 把0往后赶
        # 0 1 -》 1 0  3
        #
        zero = 0
        for i in xrange(len(nums)):
            if nums[i] != 0:
                nums[i],nums[zero] = nums[zero],nums[i]
                zero = zero + 1
