#
# @lc app=leetcode.cn id=189 lang=python3
#
# [189] 旋转数组
#

# @lc code=start
"""
    思路1: 暴力法, 选择k次
"""
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # self.rotate_v1(nums, k)
        self.rotate_v2(nums, k)
    

    def rotate_v1(self, nums, k):
        """
            思路1: 翻转k次后, 其实就是按照k = k %n 将数组分为两部分
                  第一部分是[0, len - k -1], 第二部分是[len - k, len - 1]

        """
        length = len(nums)
        k = k % length
        nums[:] = nums[length - k:] + nums[0 : length - k]
        
    def rotate_v2(self, nums, k):
        """
            思路2: 
                k = k % n
                1. reverse nums
                2. reverse nums 前k个元素, [0, k - 1]
                3. reverse nums 后n-k个元素 [k, len - 1]
        """
        length = len(nums)
        k = k % length
        nums[:] = nums[::-1]
        nums[0:k] = nums[0:k][::-1]
        nums[k:] = nums[k:][::-1]
# @lc code=end
