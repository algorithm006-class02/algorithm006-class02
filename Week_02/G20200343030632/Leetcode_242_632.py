#
# @lc app=leetcode.cn id=242 lang=python3
#
# [242] 有效的字母异位词
#

# @lc code=start
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        # return self.isAnagram_v1(s, t)
        return self.isAnagram_v2(s, t)
    
    def isAnagram_v1(self, s: str, t: str) -> bool:
        """
            暴力法:排序两个字符串, 比较排序两个字符串是否相等即可
        """
        return sorted(s) == sorted(t)
    
    def isAnagram_v2(self, s: str, t: str) -> bool:
        """
            利用哈希表, 比较两个字符串字符计数是否相同
        """
        from collections import defaultdict
        helper = defaultdict(int)
        for char in s:
            helper[char] += 1
        for char in t:
            if char not in helper:
                return False
            else:
                helper[char] -= 1
                if helper[char] == 0:
                    helper.pop(char)
        return len(helper) == 0
        
# @lc code=end

