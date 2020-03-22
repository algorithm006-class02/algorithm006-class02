


class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        res = []
        self.helper(n, 0, 0, '', res)
        return res
    
    def helper(self, n: int, left: int, right: int, s, res):
        if left == n and right == n:
            res.append(s)
            return 
        
        if left < n:
            self.helper(n, left + 1, right, s + '(', res)
        if right < left:
            self.helper(n, left, right + 1, s + ')', res)
        
