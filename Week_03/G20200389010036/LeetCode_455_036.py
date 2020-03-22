class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        g.sort()
        s.sort()
        childid = cookieid =0

        while childid < len(g) and cookieid < len(s):
            if s[cookieid] >= g[childid]:
                childid += 1
            cookieid += 1
        return childid

# class Solution:
#     def findContentChildren(self, g: List[int], s: List[int]) -> int:
#         g.sort()
#         s.sort()
#         res = 0
#         index = 0
#         for child in g:
#             while len(s) - index:
#                 if s[index] >= child:
#                     res += 1
#                     index += 1
#                     break
#                 index += 1
#         return res
