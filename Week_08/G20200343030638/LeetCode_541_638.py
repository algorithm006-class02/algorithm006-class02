class Solution:
    def reverseStr(self, s: str, k: int) -> str:
        res = ""
        n = len(s)
        for i in range(0, n, 2 * k):
            res += s[i: i + k][::-1] + s[i + k: i + 2 * k]
        return res