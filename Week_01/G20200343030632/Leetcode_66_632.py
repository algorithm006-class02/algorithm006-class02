#
# @lc app=leetcode.cn id=66 lang=python3
#
# [66] 加一
#

# @lc code=start
from typing import List
class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        """
            从后遍历数组, 判断是否需要进位即可
        """
        length = len(digits)
        for i in range(length - 1, -1, -1):
            if digits[i] < 9:
                digits[i] += 1
                return digits
            digits[i] = 0
        digits.insert(0, 1)
        return digits

if __name__ == "__main__":
    obj = Solution()        
    input = [1, 2, 2, 9]
    print(obj.plusOne(input))
# @lc code=end

