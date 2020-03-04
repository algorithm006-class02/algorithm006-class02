class Solution:
def numIslands(self, grid: List[List[str]]) -> int:
    m = len(grid)
    if m == 0:
        return 0
    n = len(grid[0])
    if n == 0:
        return 0
    count = 0
    def clear(i, j):
        if i < 0 or j < 0 or i >=  m or j >= n or grid[i][j] != "1":
            return
        grid[i][j] = "0"
        clear(i+1, j)
        clear(i-1, j)
        clear(i, j+1)
        clear(i, j-1)
    for i in range(len(grid)):
        for j in range(len(grid[i])):
            if grid[i][j] == "1":
                count += 1
            clear(i, j)
    return count
