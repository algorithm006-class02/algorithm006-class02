class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        if n == 0:
            return []
        
        ans = []
        
        def recursion(left_possible, right_possible, temp, ans):
            if left_possible == right_possible == 0:
                ans.append(temp)
            if left_possible > 0:
                recursion(left_possible - 1, right_possible + 1, temp + '(', ans)
            if right_possible > 0:
                recursion(left_possible, right_possible - 1, temp + ')', ans)
        
        recursion(n, 0, '', ans)
        return ans
