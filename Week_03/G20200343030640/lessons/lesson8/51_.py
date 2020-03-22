# -*- coding: utf-8 -*-
"""
51. N皇后
n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
思路：n个皇后，nxn的棋盘，每行只能放一个皇后；当行数row >= n 时，则找到了一种方案；
若某一行的某列可以放一个Q（皇后）， 其所在的col, pie, na 线上都不能再放Q；
pie: row+ col == C (常数)
na: row-col == C
"""

class Solution:
    def __init__(self):
        self.ans = []
        self.track = []
        self.cols = set()
        self.pie = set() # row + col
        self.na = set()  # row - col
    
    def generate_qipan(self, n):
        res = []
        for an in self.ans:
            res.append(['.'*col+'Q'+'.'*(n-1-col) for col in an])
        return res

    def solveNQueens(self, n: int) -> List[List[str]]:
        if n == 0:
            return []
        
        self.backtrack(n, 0, self.track)
        return self.generate_qipan(n)

    def backtrack(self, n, row, track):
        if row >= n:
            # 满足条件，放入结果集
            self.ans.append(track)
            return
        
        for col in range(0, n):
            if col in self.cols or row+col in self.pie or row-col in self.na:
                continue
            # 选择操作
            self.cols.add(col)
            self.pie.add(row+col)
            self.na.add(row-col)
            # 下探
            self.backtrack(n, row+1, track+[col])
            # 回溯上一层
            self.cols.remove(col)
            self.pie.remove(row+col)
            self.na.remove(row-col)
        