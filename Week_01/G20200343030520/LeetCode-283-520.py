from typing import List

class Solution():
    """ Given an array nums, write a function to move all 0's to the end of it
        while maintaining the relative order of the non-zero elements.

        Example:
            Input: [0, 1, 0, 3, 12]
            Output: [1, 3, 12, 0, 0]

        Note:
            1. You must do this in-place without making a copy of array.
            2. Minimize the total number of operations.

        Link: https://leetcode.com/problems/move-zeros/
    """
    def moveZeroes(self, nums: List[int]) -> None:
        """ Do not return anything, modify nums in-place instead.
        """
        slow = fast = 0
        while fast < len(nums):
            if nums[fast] != 0:
                nums[fast], nums[slow] = nums[slow], nums[fast]
                slow += 1
            fast += 1

if __name__ == "__main__":
    
    nums  = [0, 1, 0, 3, 12]

    s = Solution()
    s.moveZeroes(nums)