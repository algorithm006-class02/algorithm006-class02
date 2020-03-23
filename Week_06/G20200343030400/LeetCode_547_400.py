class Solution:
    def findCircleNum(self, M: List[List[int]]) -> int:
        if not M: return 0

        m = len(M)
        p = [i for i in range(m)]

        for i in range(m):
            for j in range(i + 1, m):
                if M[i][j] == 1:
                    self._union(p, i, j)

        return len(set([self._parent(p, i) for i in range(m)]))

    def _union(self, p, i, j):
        pi = self._parent(p, i)
        pj = self._parent(p, j)
        p[pi] = pj

    def _parent(self, p, i):
        root = i
        while p[root] != root:
            root = p[root]
        while p[i] != i:
            x = i; i = p[i]; p[x] = root
        return root
