class Solution:
    def findCircleNum(self, M: List[List[int]]) -> int:
        if not M: return 0
        n = len(M)
        parent = [i for i in range(n)]

        for i in range(n):
            for j in range(n):
                if M[i][j] == 1:
                    self._union(parent, i, j)
        
        return len(set([self._parent(parent, i) for i in range(n)]))
        
    
    def _union(self, parent, i, j):
        p1 = self._parent(parent, i)
        p2 = self._parent(parent, j)
        parent[p2] = p1 
        
    def _parent(self, parent, i):
        root = i
        while parent[root] != root:
            root = parent[root]
        while parent[i] != i:
            x = i
            i = parent[i]
            parent[x] = root
        return root