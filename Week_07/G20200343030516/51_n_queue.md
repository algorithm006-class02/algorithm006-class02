51. N皇后
n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。



上图为 8 皇后问题的一种解法。

给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。

每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。

示例:

输入: 4
输出: [
 [".Q..",  // 解法 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // 解法 2
  "Q...",
  "...Q",
  ".Q.."]
]
解释: 4 皇后问题存在两个不同的解法。
通过次数31,695提交次数46,201

solution
放弃了 bit解法：

```python
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        cols = []
        sum_xy = set()
        min_xy = set()
        output = []

        def backtrack(row = 0 ):
            if row == n:
                res = []
                for i in range(n):
                    res.append("." *cols[i] + "Q" + (n-1 -cols[i] )*"."  )
                output.append(res)
                

            for col in range(n):
                if col not in cols and col + row not in sum_xy and row - col not in min_xy:
                    cols.append(col)
                    sum_xy.add(row + col)
                    min_xy.add(row - col)
                    backtrack( row + 1 )
                    cols.pop()
                    sum_xy.remove(row + col )
                    min_xy.remove(row - col )

        backtrack()
        return output
                





        # def could_place(row, col):
        #     return not (cols[col] + hill_diagonals[row - col] + dale_diagonals[row + col])
        
        # def place_queen(row, col):
        #     queens.add((row, col))
        #     cols[col] = 1
        #     hill_diagonals[row - col] = 1
        #     dale_diagonals[row + col] = 1
        
        # def remove_queen(row, col):
        #     queens.remove((row, col))
        #     cols[col] = 0
        #     hill_diagonals[row - col] = 0
        #     dale_diagonals[row + col] = 0
        
        # def add_solution():
        #     solution = []
        #     for _, col in sorted(queens):
        #         solution.append('.' * col + 'Q' + '.' * (n - col - 1))

```