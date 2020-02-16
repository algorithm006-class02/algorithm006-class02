# =====================================
# No.283 零移动
# 解题思路：双指针i、j，j存储需要下一个替换为非0数字的索引
# =====================================
class Solution(object):
    def moveZeroes(self, nums):
        i=j=temp=0
        for i in range(len(nums)):
            if(nums[i] != 0):
                nums[i],nums[j] = nums[j],nums[i]
                j=j+1