438. 找到字符串中所有字母异位词
给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。

字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。

说明：

字母异位词指字母相同，但排列不同的字符串。
不考虑答案输出的顺序。
示例 1:

输入:
s: "cbaebabacd" p: "abc"

输出:
[0, 6]

解释:
起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 示例 2:

输入:
s: "abab" p: "ab"

输出:
[0, 1, 2]

解释:
起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。

```python
class  Solution:
    def findAnagrams(self,s:str,p:str) -> List[int]:
        p_count = [0] *26
        s_count = [0] *26
        for a  in p:
            p[ord(a) - 97] +=1
        left = 0
        for right in range(len(s)):
            if right < len(p) -1:
                s_count[ord(s[right]) -97] +=1
                continue
            s_count[ord(s[right]) -97] +=1
            if p_count == s_count:
                res.append(left)
            s_count[ord(s[left] -97)] -=1
            left +=1
        return ans


```