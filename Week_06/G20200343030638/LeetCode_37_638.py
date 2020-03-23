class Solution:
    def solveSudoku(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        rows = [set(range(1, 10)) for _ in range(9)] # 行剩余可用数字
        columns = [set(range(1, 10)) for _ in range(9)]    # 列剩余可用数字
        boxes = [set(range(1, 10)) for _ in range(9)]      # 块剩余可用数字

        empty = [] # 收集需填数位置

        for i in range(9):
            for j in range(9):
                index = (i // 3 ) * 3 + j // 3
                num = board[i][j]
                if num != '.': # 更新可用数字
                    val = int(num)
                    rows[i].remove(val)
                    columns[j].remove(val)
                    boxes[index].remove(val)
                else:
                    empty.append((i, j))

        def backtrack(iter=0):
            if iter == len(empty): # 处理完empty代表找到了答案
                return True
            i, j = empty[iter]
            b = (i // 3 ) * 3 + j // 3
            for val in rows[i] & columns[j] & boxes[b]:
                rows[i].remove(val)
                columns[j].remove(val)
                boxes[b].remove(val)
                board[i][j] = str(val)
                if backtrack(iter + 1):
                    return True
                rows[i].add(val) # 回溯
                columns[j].add(val)
                boxes[b].add(val)
            return False
        backtrack()