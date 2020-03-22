class Solution:
def minPathSum(self, grid: List[List[int]]) -> int:
    if len(grid) == 0:
        return 0
    m = len(grid)
    n = len(grid[0])
    # 初始化
    pd = [n for n in grid[0]]
    for i in range(1, n):
        pd[i] += pd[i-1]
    # PD: pd[i] = min(pd[i-1], pd[i]) + a[i]
    for i in range(1, m):
        for j in range(n):
            pd[j] = (pd[j] if j == 0 else min(pd[j - 1], pd[j])) + grid[i][j]
    return pd[-1]
