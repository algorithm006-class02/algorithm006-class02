541. 反转字符串 II
给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。如果剩余少于 k 个字符，则将剩余的所有全部反转。如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。

示例:

输入: s = "abcdefg", k = 2
输出: "bacdfeg"

### solution
```python
class Solution(object):
    def reverseStr(self, s, k):
        a = list(s)
        for i in range(0, len(a), 2*k):
            a[i:i+k] = reversed(a[i:i+k])
        return "".join(a)
```

java
```java
class Solution{
    public String reverseStr(String s,int k){
        char[ ] a = s.toCharArray();
        for(int start = 0, start< a.length-1;start+=2*k)
        {
            int i = start, j = Math.min(start + k-1,a.length-1);
            while(i<j){
                char tmp = a[i]
                a[i++] = a[j]
                a[j--] = tmp
            }

        }
        return new String(a);
    }
}
```