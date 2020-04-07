709. 转换成小写字母
实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。

 

示例 1：

输入: "Hello"
输出: "hello"
示例 2：

输入: "here"
输出: "here"
示例 3：

输入: "LOVELY"
输出: "lovely"

### solution
需要了解各语言的自带api,

python: str.lower()
javascript: str.toLowerCase()
java: char toLowerCase(char ch)
```python
    def toLowerCase(self, str: str) -> str:
        return str.lower()
```