# Given an array nums, write a function to move all 0's to the end of it while m
# aintaining the relative order of the non-zero elements. 
# 
#  Example: 
# 
#  
# Input: [0,1,0,3,12]
# Output: [1,3,12,0,0] 
# 
#  Note: 
# 
#  
#  You must do this in-place without making a copy of the array. 
#  Minimize the total number of operations. 
#  Related Topics Array Two Pointers


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def moveZeroes(self, nums) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        i = j = 0
        for i in range(len(nums)):
            if nums[i] != 0:
                nums[i], nums[j] = nums[j], nums[i]
                j += 1

# 遍历的时候， 如果该元素不为0，则将该元素与前面为0得元素调换位置，前面为0得元素为nums[j].


# leetcode submit region end(Prohibit modification and deletion)
