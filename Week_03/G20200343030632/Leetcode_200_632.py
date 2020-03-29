from typing import List
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        # dfs
        row_length = len(grid)
        col_length = len(grid[0])
        res = 0
        for i in range(row_length):
            for j in range(col_length):
                if grid[i][j] == '1':
                    res += 1
                    self.helper(i, j, grid)
            
        return res
    def helper(self, row, col, grid):
        # terminated
        if row < 0 or col < 0 or row >= len(grid) or col >= len(grid[0]) or grid[row][col] != '1':
            return None

        # current level 
        grid[row][col] = 0

        # drill down
        self.helper(row - 1, col, grid)
        self.helper(row, col - 1, grid)
        self.helper(row + 1, col, grid)
        self.helper(row, col + 1, grid)

    
if __name__ == "__main__":
    input = [
        ["1","1","1","1","0"],
        ["1","1","0","1","0"],
        ["1","1","0","0","0"],
        ["0","0","0","0","0"]
    ]
    obj = Solution()
    res = obj.numIslands(input)
    print(res)