class Solution:
def longestPalindrome(self, s: str) -> str:
    if len(s) < 2:
        return s
    def lenPalinadrome(i, j):
        ret = ""
        while i >= 0 and j < len(s) and s[i] == s[j]:
            ret = s[i:j+1]
            i -= 1
            j += 1
        return ret
    
    maxP = ""
    for i in range(len(s) - 1):
        ii = lenPalinadrome(i, i)
        ij = lenPalinadrome(i, i+1)
        cur = ii if len(ii) > len(ij) else ij
        if len(cur) > len(maxP):
            maxP = cur
    return maxP
