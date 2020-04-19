class Solution:
    def validPalindrome(self, s: str) -> bool:
        l, r = 0, len(s) - 1
        while l < r:
            if s[l] != s[r]:
                return self._valid(s, l, r - 1) or self._valid(s, l + 1, r)
            l += 1
            r -= 1
        
        return True

    def _valid(self, s, l, r):
        while l < r:
            if s[l] != s[r]:
                return False
            l += 1
            r -= 1
        return True