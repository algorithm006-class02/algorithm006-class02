from typing import List

class Solution():
    """ Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
        The digits are stored such that the most significant digit is at the head of the list, and each
        element in the array contain a single digit.
        
        You may assume the integer does not contain any leading zero, except the number 0 itself.

        Example:
            Input: [1,2,3]
            Output: [1,2,4]

        Link: https://leetcode.com/problems/plus-one/
    """
    def plusOne(self, digits: List[int]) -> None:
        """ Do not return anything, modify nums in-place instead."""
        
        nums = 0
        for i in range(len(digits)):
            nums += digits[i] * pow(10, len(digits)-1-i)

        nums = nums +1
        return [int(i) for i in str(nums)]



if __name__ == "__main__":
    
    nums  = [1,2,3]

    s = Solution()
    x = s.plusOne(nums)

    print(x)

