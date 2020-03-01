# 时间复杂度：O(NKlogK)
# K是strs中字符串的最大长度，排序O(Klog(K))
# N是strs长度，循环O(N)
# 总的O(Klog(K)) * O(N) = O(NKlogK)
def groupAnagrams(strs):
    n = len(strs)
    if (not n):
        return []
    result = {}
    for i in range(0, n):
        value = strs[i]
        key = "".join(sorted(value))
        tmp = result.get(key, [])
        tmp.append(value)
        result[key] = tmp
    # return list(map(lambda key: result[key], result))
    return result.values()


tmp = ["eat", "tea", "tan", "ate", "nat", "bat"]
print(groupAnagrams(tmp))


# 官方解法
class Solution(object):
    def groupAnagrams(self, strs):
        ans = collections.defaultdict(list)
        for s in strs:
            ans[tuple(sorted(s))].append(s)
        return ans.values()
