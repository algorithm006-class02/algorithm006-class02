#
# @lc app=leetcode.cn id=20 lang=python3
#
# [20] 有效的括号
#

# @lc code=start
class Solution:
    def isValid(self, s: str) -> bool:
        """
            利用栈的思路解决问题:
            左括号进栈, 右括号判断与栈顶元素是否匹配, 匹配则出栈
            栈空则有效
        """
        match_maps = {
            '(' : ')',
            '{' : '}',
            '[' : ']'
        }
        stack = ['@']
        for char in s:
            if char in match_maps:
                stack.append(char)
            elif match_maps.get(stack.pop()) != char:
                return False
        return len(stack) == 1
    
    
        
# @lc code=end

