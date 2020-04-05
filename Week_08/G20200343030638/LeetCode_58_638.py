class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        res = 0
        flag = 0
        for i in reversed(s):
            if i is ' ' and flag == 0:
                continue
            if i is not ' ':
                res += 1
                flag = 1
            else:
                break
        
        return res