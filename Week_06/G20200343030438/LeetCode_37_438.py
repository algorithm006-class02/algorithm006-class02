class Solution:
    def solveSudoku(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        
        row = [set(range(1,10)) for i in range(9)]
        column = [set(range(1,10)) for i in range(9)]
        block = [set(range(1,10)) for i in range(9)]
        
        empty = []
        
        for i in range(9):
            for j in range(9):
                if board[i][j] == '.':
                    empty.append((i,j))
                else:
                    value = int(board[i][j])
                    k = (j // 3) * 3 + i // 3
                    row[i].remove(value)
                    column[j].remove(value)
                    block[k].remove(value)
        
        def backtrack(iter = 0):
            if iter == len(empty):
                return True
            i,j = empty[iter]
            k = (j // 3) * 3 + i // 3
            for val in row[i] & column[j] & block[k]:
                row[i].remove(val)
                column[j].remove(val)
                block[k].remove(val)
                board[i][j] = str(val)
                if backtrack(iter+1):
                    return True
                row[i].add(val)
                column[j].add(val)
                block[k].add(val)
            return False
        backtrack()