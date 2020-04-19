class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        res = []
        left = right = 0
        
        # 两个计数器
        window = {}
        needs = dict((i, p.count(i)) for i in p)
        # 记录window中有多少个字符符合要求
        match = 0

        while right < len(s):
            c = s[right]
            if c in needs.keys():
                window[c] = window.get(c, 0) + 1
                if window[c] == needs[c]:
                    match += 1
            right += 1

            while match == len(needs):
                if right - left == len(p):
                    res.append(left)
                c2 = s[left]
                if c2 in needs.keys():
                    window[c2] -= 1
                    if window[c2] < needs[c2]:
                        match -= 1
                left += 1

        return res