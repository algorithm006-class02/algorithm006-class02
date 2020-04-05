5. 最长回文子串
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：

输入: "cbbd"
输出: "bb"

### Solution
中心扩展

```python
class Solution:
    def longestPalindrome(self, s: str) -> str:
        if not s or len(s) == 1: return s
        
        start,end = 0,0
        length =len(s)

        def helper(begin,end):
            while begin >= 0 and end <length and s[begin] == s[end]:
                begin -=1
                end +=1
            return end - begin -1

        for i in range(length):
            len_a = helper(i,i)
            len_aa = helper(i,i+1)
            lens = max(len_a,len_aa)
            if(lens > end -start):
                start = i -(lens-1)//2
                end = i + lens//2
        return s[start: end +1] 
```
```java
class Soluton {
    public String longestPalindrome(String s){
        if (s == null || s.length() < 1) return '';
        int start = 0, end = 0
        for(int i = 0; i< s.length();i++){
            int len1 = expand(s,i,i)
            int len2 = expand(s,i,i+1)
            len = max(len1,len2)
            if (len > end -start){
                start = i -(len-1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start,end + 1);
    }

    private int expand(String s, int begin, int right){
        int L = left, R = right;
        while(L >= 0 && R<=s.length() && s.charAt(L)==s.charAt(R)){
            L--;
            R++;
        }
        return R - L -1;

    }

}
```