

## solution
```python
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        res = []
        cols = set()
        xySum = set()
        xyMinus = set()

        def backtrack(N,row,cur_state):
        # recursion terminator
            if row >= N:
                res.append(cur_state)
                return

        # recursion level
            for col in range(N):
                if col in cols or row + col  in xySum or row -col in xyMinus:
                    continue

                cols.add(col)
                xySum.add(col + row)
                xyMinus.add( row - col )

                backtrack(N,row+1,cur_state + [col])

                cols.remove(col)
                xySum.remove(col + row)
                xyMinus.remove(row -col)


        def generate():
            ans = [ [("."*i + "Q" + "."*(n-i -1))  for i in item ] for item in res ]
            return ans

        backtrack(n,0,[])
        return generate()
```