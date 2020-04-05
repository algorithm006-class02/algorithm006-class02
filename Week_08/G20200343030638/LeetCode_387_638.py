class Solution:
    def firstUniqChar(self, s: str) -> int:
        for i in range(len(s)):
            res = s.count(s[i])
            if res == 1:
                return i
        return -1