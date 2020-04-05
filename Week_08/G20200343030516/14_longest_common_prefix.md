14. 最长公共前缀
编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:

输入: ["flower","flow","flight"]
输出: "fl"
示例 2:

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
说明:

所有输入只包含小写字母 a-z 。


### solution
```python
class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        if not strs:return ""
        if len(strs) == 1:return strs[0]
        ans = ''
        strs = sorted(strs,key=lambda x : len(x))
        for i in range(len(strs[0])):
            char = strs[0][i]
            for strItem in strs[1:]:
                if strItem[i] == char:
                    continue
                else:
                    return ans
            ans += char
        return ans
```