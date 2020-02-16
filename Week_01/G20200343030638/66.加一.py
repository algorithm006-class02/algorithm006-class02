class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        for i in range(1, len(digits) + 1):
            if digits[-i] != 9:
                digits[-i] += 1
                return digits
                
            digits[-i] = 0

        digits.insert(0, 1)
        return digits