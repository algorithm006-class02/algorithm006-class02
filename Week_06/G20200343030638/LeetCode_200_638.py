class Union_set:
    def __init__(self, n):
        self.data = [i for i in range(n)]   # 记录每个节点的祖先节点
        self.size = [1] * n                 # 记录每个节点的子树的节点数
        self.cnt = n                        # 记录当前的集合数量
    
    def find(self, m):
        """
        查找祖先（根节点）。时间复杂度接近O(1)。
        """
        if self.data[m] == m:
            return m
        ancestor = self.find(self.data[m])  # 找到祖先节点（根节点）
        self.data[m] = ancestor
        return ancestor
    
    def union(self, a, b):
        """
        对两个节点相连。时间复杂度接近O(1)。
        """
        ancestor_a = self.find(a)
        ancestor_b = self.find(b)
        if ancestor_a == ancestor_b:
            return
        
        if self.size[ancestor_a] > self.size[ancestor_b]:
            self.data[ancestor_b] = ancestor_a
            self.size[ancestor_a] += ancestor_b
        else:
            self.data[ancestor_a] = ancestor_b
            self.size[ancestor_b] += ancestor_a
        self.cnt -= 1

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid: return 0
        n = len(grid)
        m = len(grid[0])
        us = Union_set(n * m)
        
        for i in range(n):
            for j in range(m):
                if i > 0 and grid[i][j] == '1' and grid[i - 1][j] == '1':
                    us.union(i * m + j, (i - 1) * m + j)
                if j > 0 and grid[i][j] == '1' and grid[i][j - 1] == '1':
                    us.union(i * m + j, i * m + (j - 1))
        num = 0
        for i in range(n):
            for j in range(m):
                res = i * m + j
                if us.data[res] == res and grid[i][j] == '1':
                    num += 1
        return num