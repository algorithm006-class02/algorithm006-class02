class Solution(object):
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """

        # 法一：统计零数
        # index = 0
        # size = len(size)
        # for i in range(size):
        #     if nums[i] != 0:
        #         nums[index] = nums[i]
        #         index += 1
        
        # nums[index:] = [0] * (size - index)

        # 法二：快慢指针
        j = 0
        for i in range(len(nums)):
            if nums[i] != 0:
                nums[i], nums[j] = nums[j], nums[i]
                j += 1