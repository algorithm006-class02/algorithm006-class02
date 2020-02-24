class Solution(object):
    def groupAnagrams(self, strs):
        hashmap = {}
        for st in strs:
            key = ''.join(sorted(st))
            if key not in hashmap:
                hashmap[key] = [st]
            else:
                hashmap[key] += [st]
        return hashmap.values()