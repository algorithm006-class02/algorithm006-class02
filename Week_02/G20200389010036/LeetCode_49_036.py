# https://leetcode-cn.com/problems/group-anagrams/
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        from collections import defaultdict
        res = defaultdict(list)

        for s in strs:
            count = [0]*26
            for item in s:
                count[ord(item)-ord('a')] += 1
            res[tuple(count)].append(s)

        return res.values()


# class Solution:
#     def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
#         from collections import defaultdict
#         res = defaultdict(list)

#         for item in strs:
#             res[tuple(sorted(item))].append(item)
        
#         return res.values()