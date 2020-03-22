class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if len(grid)==0:return 0
        cnt, x_size, y_size = 0, len(grid), len(grid[0])
        for x in range(x_size):
            for y in range(y_size):
                if grid[x][y] == "1":
                    cnt += 1
                    self.infect(x, y, grid)
        return cnt

    def infect(self, x, y, grid: List[List[str]]):
        grid[x][y] = "0"
        if x - 1 >= 0 and grid[x - 1][y] == "1": self.infect(x - 1, y, grid)
        if x + 1 < len(grid) and grid[x + 1][y] == "1": self.infect(x + 1, y, grid)
        if y - 1 >= 0 and grid[x][y - 1] == "1": self.infect(x, y - 1, grid)
        if y + 1 < len(grid[0]) and grid[x][y + 1] == "1": self.infect(x, y + 1, grid)