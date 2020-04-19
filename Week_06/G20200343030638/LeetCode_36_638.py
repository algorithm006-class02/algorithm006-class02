class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rows = [{} for _ in range(9)]
        columns = [{} for _ in range(9)]
        boxes = [{} for _ in range(9)]

        for i in range(9):
            for j in range(9):
                index = (i // 3 ) * 3 + j // 3
                num = board[i][j]
                if num != '.':
                    rows[i][num] = rows[i].get(num, 0) + 1
                    columns[j][num] = columns[j].get(num, 0) + 1
                    boxes[index][num] = boxes[index].get(num, 0) + 1

                    if rows[i][num] > 1 or columns[j][num] > 1 or boxes[index][num] > 1:
                        return False
        
        return True