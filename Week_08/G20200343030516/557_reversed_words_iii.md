557. 反转字符串中的单词 III
给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。

示例 1:

输入: "Let's take LeetCode contest"
输出: "s'teL ekat edoCteeL tsetnoc" 
注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。

### Solution
```python
class Solution:
    def reverseWords(self, s: str) -> str:
        res = [ ]
        for word in s.split(' '):
            res.append( word[::-1])
        return ' '.join(res)
```

java
```java
public class Solution{
    public String reverseWords(String s){
        String words[]= s.split(' ');
        StringBuilder res = new StringBuilder();
        for(String word:words)
            res.append(new StringBuffer(word).reverse().toString() + ' ');
        return res.toString().trim();
    }
}
```