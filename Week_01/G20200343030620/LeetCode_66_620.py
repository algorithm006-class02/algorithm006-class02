class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        stack = []
        i = len(digits) - 1
        dit = 1
        while i >= 0:
            num = (digits[i] + dit) % 10
            stack.append(num)
            dit = int((digits[i] + dit) / 10)
            i -= 1
        if dit != 0:
            stack.append(dit)
        stack.reverse()
        return stack
