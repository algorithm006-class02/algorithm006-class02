//22
//https://leetcode.com/problems/generate-parentheses/

class Solution:

    def nextPermutation(self, lst):
        n = len(lst)
        i = n-2 
        while i>=0 and lst[i+1] <= lst[i]: i -= 1 
        if i >= 0: 
            j = n-1 
            while j >= 0 and lst[j] <= lst[i]: j -= 1
            lst[i], lst[j] = lst[j], lst[i] 
        lst[i+1:n] = list(reversed(lst[i+1:n]))
        return lst

    def isValid(self, paratheses):
        count = 0
        for char in paratheses:
            if char == "(":
                count += 1
            elif char == ")":
                count -= 1
                if count < 0:
                    return False
        return True

    def generateParenthesis(self, n: int) -> List[str]:
        ans = []
        s = list("(" * n + ")" * n)
        s_final = list("()" * n)

        while operator.le(s, s_final):
            if self.isValid(s):
                ans.append("".join(s));
            s = self.nextPermutation(s)
               
        return ans        
