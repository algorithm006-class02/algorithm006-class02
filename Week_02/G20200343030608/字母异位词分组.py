class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        from collections import defaultdict
        dict_ = defaultdict(list)

        for s in strs:
            dict_[tuple(sorted(s))].append(s)  
        return list(dict_.values())
