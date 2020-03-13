# -*- coding: utf-8 -*-
"""
22. 括号生成
给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
"""

# (1) 使用递归思想，拼接字符串S, 得出所有可能的组合; 
class Solution1:
    def __init__(self):
        self.result = []
    def generateParenthesis(self, n):
        if n == 0:
            return []
        
        self.dfs(0, 0, n, '')
        print(self.result)

    def dfs(self, left, right, n, s):
        if left == n and right == n:
            self.result.append(s)

        # left, right 下标从0开始，不能等于 n
        if left < n:
            self.dfs(left+1, right, n, s+'(')
        
        if right < n:
            self.dfs(left, right+1, n, s+')')

# (2) 在一的基础上去掉不合法的元素，当左括号大于等于右括号时，才能使用右括号
class Solution2:
    def __init__(self):
        self.result = []
    
    # 入口函数
    def generateParenthesis(self, n):
        if n == 0:
            return []
        
        self.backtrack(0, 0, n, '')
        return self.result

    def backtrack(self, left, right, n, s):
        if left == n and right == n:
            self.result.append(s)

        if left < n:
            self.backtrack(left+1, right, n, s+'(')
        
        if right <= left:
            self.backtrack(left, right+1, n, s+')')

# (3) 官方题解的回溯法
"""
class Solution3 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, String cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (open < max)
            backtrack(ans, cur+"(", open+1, close, max);
        if (close < open)
            backtrack(ans, cur+")", open, close+1, max);
    }
}
"""
