# =====================================
# No.26 删除排序数组中的重复项
# 解题思路：双指针i、j，如果nums[i]与nums[j]不相同，就将nums[j]赋予i+1位置
# =====================================
class Solution(object):
    def removeDuplicates(self, nums):
        i=0
        j=1
        for j in range(len(nums)):
            if (nums[i] != nums[j]):
                i=i+1
                nums[i] = nums[j]
        return (i+1)