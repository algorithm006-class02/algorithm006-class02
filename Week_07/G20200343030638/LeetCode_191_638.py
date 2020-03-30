class Solution:
    def hammingWeight(self, n: int) -> int:
        sum = 0
        while n:
            sum += 1
            n = n & (n -1)        
        return sum