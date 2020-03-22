#
# @lc app=leetcode.cn id=49 lang=python3
#
# [49] 字母异位词分组
#

# @lc code=start
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        return self.groupAnagrams_v1(strs)
    def groupAnagrams_v1(self, strs: List[str]) -> List[List[str]]:
        helper = {}
        res = []
        for item in strs:
            key = ''.join(sorted(item))
            if key in helper:
                helper[key].append(item)
            else:
                helper[key] = [item]
        
        for val in helper.values():
            res.append(val)

        return res

        
# @lc code=end

        