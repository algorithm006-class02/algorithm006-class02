class Solution:
    def reverseWords(self, s: str) -> str:
        s = s.strip()
        ls = s.split()
        l, r = 0, len(ls) - 1
        while l < r:
            ls[l], ls[r] = ls[r], ls[l]
            l += 1
            r -= 1
        return " ".join(ls)