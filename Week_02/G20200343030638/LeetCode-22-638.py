class Solution:
    def __init__(self):
        self.res = []

    def generateParenthesis(self, n: int) -> List[str]:
        self._generate(0, 0, n, "")
        return self.res
    
    def _generate(self, left: int, right: int, n: int, s: str):
        if left == n and right == n:
            self.res.append(s)
            return
        
        ls = s + "("
        lr = s + ")"

        if left < n:
            self._generate(left + 1, right, n, ls)

        if right < left:
            self._generate(left, right + 1, n, lr)