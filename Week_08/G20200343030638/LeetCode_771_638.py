class Solution:
    def numJewelsInStones(self, J: str, S: str) -> int:
        res = 0
        for i in S:
            for j in J:
                if i == j:
                    res += 1
                    break
        
        return res