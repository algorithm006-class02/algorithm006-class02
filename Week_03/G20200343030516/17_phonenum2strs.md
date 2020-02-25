## description

17. 电话号码的字母组合
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。



示例:

输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
说明:
尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。

### solution

1. iter
for python list comprehension,need fist generate the case with digits[0]
```python
    def letterCombinations(self, digits: str) -> List[str]:
       if not digits:return []
        num2al = {
            "1" :"",
            "2": 'abc',
            "3": 'def',
            "4": "ghi",
            "5": "jkl",
            "6": "mno",
            "7": "pqrs",
            "8": "tuv",
            "9": 'wxyz'
        }
        ans = [ _ for _ in num2al[digits[0]] ]
        for digit in digits[1:]:
            ans = [ x + y for x in ans for y in num2al[digit]]

        return ans

```

2.backtrack

```python
    def letterCombinations(self, digits: str) -> List[str]:
        num2al = {
            "1" :"",
            "2": 'abc',
            "3": 'def',
            "4": "ghi",
            "5": "jkl",
            "6": "mno",
            "7": "pqrs",
            "8": "tuv",
            "9": 'wxyz'
        }
        ans = []

        def helper(strs,combination):
            if len(strs) == 0: 
                ans.append(combination)
                return
            for letter in num2al[strs[0]]:
                helper(strs[1:],combination + letter)

        if digits:
            helper(digits,'')
        return ans
```