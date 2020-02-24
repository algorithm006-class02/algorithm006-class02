class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        dict = {}

        for s in strs:
            tmp = tuple(sorted(s))
            dict[tmp] = dict.get(tmp, []) + [s]

        return dict.values()