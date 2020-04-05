680. 验证回文字符串 Ⅱ
给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。

示例 1:

输入: "aba"
输出: True
示例 2:

输入: "abca"
输出: True
解释: 你可以删除c字符。

### solution
1. len(s) <= 2 ? true : s[ :s.length-1] || s[1 :]
```javascript
/**
 * @param {string} s
 * @return {boolean}
 */
var validPalindrome = function(s, flag = true) {
    let l = 0, r = s.length - 1;
    while (l < r && s[l] === s[r]) l++, r--;
    if (r <= l) return true;
    if (flag == true) return validPalindrome(s.slice(l, r), false) || validPalindrome(s.slice(l + 1, r + 1), false)
    return false;
};

```