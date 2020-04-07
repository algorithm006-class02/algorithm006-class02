from collections import OrderedDict


class Solution(object):

    def firstUniqChar(self, s: str) -> int:
        odict = OrderedDict()

        # 记录字符出现次数
        for c in s:
            odict[c] = odict[c] + 1 if c in odict else 1

        # 利用有序的特性，在字典中找出首个出现次数为一的字符串
        for k, v in odict.items():
            if v == 1:
                # 返回字符串首次出现的位置
                return s.index(k)

        return -1

