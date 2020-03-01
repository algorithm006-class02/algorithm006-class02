#!/usr/bin/env python

class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        counts = [0] * 26
        for i in s:
            counts[ord(i) - ord('a')] += 1

        for i in t:
            counts[ord(i) - ord('a')] -= 1
        return all(count == 0 for count in counts)


"""
思路: 哈希定址法

遍历
s 对应位置增加
t 对应位置减少
如果哈希表的值都为0
则二者是字母异位词

还有其他哈希方法，待学习
实在太难了，进度很慢
"""