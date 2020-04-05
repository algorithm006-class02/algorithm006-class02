151. 翻转字符串里的单词
给定一个字符串，逐个翻转字符串中的每个单词。

 

示例 1：

输入: "the sky is blue"
输出: "blue is sky the"
示例 2：

输入: "  hello world!  "
输出: "world! hello"
解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
示例 3：

输入: "a good   example"
输出: "example good a"
解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。

### solution
```python
class Solution:
    def reverseWords(self, s: str) -> str:
        res = [ word for word in s.split(' ') if word ]
        return ' '.join(reversed(res))
```

java
```java
class Solution{
    public String reversedWords(String s){
        s = s.trim();
        List<String> wordlist  = Array.asList(s.split("\\s+"));
        Collections.reverse(wordlist);
        return String.join(' ',wordList)
    }
}
```