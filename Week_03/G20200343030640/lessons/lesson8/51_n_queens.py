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
            self.ans.append(track)
            return
        
        for col in range(0, n):
            if col in self.cols or row+col in self.pie or row-col in self.na:
                continue
            
            self.cols.add(col)
            self.pie.add(row+col)
            self.na.add(row-col)

            self.backtrack(n, row+1, track+[col])

            self.cols.remove(col)
            self.pie.remove(row+col)
            self.na.remove(row-col)
        