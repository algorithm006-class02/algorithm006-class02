# coding:utf8

from typing import List
class Solution:

    # N皇后问题
    def solveNQueens(self, n: int) -> List[List[str]]:
        return self.solveNQueens_v1(n)

    def solveNQueens_v1(self, n: int) -> List[List[str]]:
        res = []
        self.helper(n, [], [], [], res)
        return [['.' * i + 'Q' + '.' * (n-i-1) for i in sol] for sol in res]
    
    def helper(self, n, queens: List, pie : List, na : List, res):
        p = len(queens)
        # terminated
        if p == n:
            res.append(queens)
            return

        # handle current level
        for i in range(n):

            if i not in queens and p + i not in pie and p - i not in na:
                self.helper(n, queens + [i], pie + [p + i], na + [p - i], res)
        
        # revert 

if __name__ == "__main__":
    obj = Solution()
    obj.solveNQueens(4)

