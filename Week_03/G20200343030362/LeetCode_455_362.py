class Solution:
def findContentChildren(self, g: List[int], s: List[int]) -> int:
    if not g or not s:
        return 0
    g.sort()
    s.sort()
    res, m, l = 0, 0, len(s)
    for c in g:
        while s[m] < c:
            m += 1
            if m == l:
                return res
        res += 1
        m += 1
        if m == l:
            return res
    return res
