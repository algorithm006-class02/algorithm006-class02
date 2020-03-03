# py3

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        if strs is None:
            return []

        result = dict()
        for item in strs:
            anastr = ''.join(sorted(item))
            if not result.get(anastr, None):
                result.setdefault(anastr, [item])
            else:
                result[anastr].append(item)
        
        return [ v for _, v in result.items()]
        
        # 官方题解
        # ans = collections.defaultdict(list)
        # for s in strs:
        #     ans[tuple(sorted(s))].append(s)
        # return ans.values()

