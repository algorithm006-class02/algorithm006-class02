class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        j = 0
        for i in digits:
            j = j*10 + i
        k = str(j + 1)
        return([int(i) for i in k])
