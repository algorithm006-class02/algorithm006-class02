class Solution(object):
    
    def findCircleNum(self, M):
        """
        :type M: List[List[int]]
        :rtype: int
        """
        R = len(M)
        C = len(M[0])
        parent = [i for i in range(R)]
        print(parent)
        # i == j: 主对角线自身为朋友
        for i in range(R):
            for j in range(C):
                if M[i][j] == 1 and i != j:
                    self.union(parent, i,j)
        print(parent)
        count = 0
        for i in range(len(parent)):
            if i == parent[i]:
                count += 1
        return count
    
    def find(self, parent, i):
        root = i
        while parent[root] != root:
            root = parent[root]
        # 路径压缩，将满足条件的i,j 父节点都置为根节点
        while parent[i] != i:
            x = i
            i = parent[i]
            parent[x] = root

        return root

    def union(self, parent, i, j):
        parent_i = self.find(parent, i)
        parent_j = self.find(parent, j)
        
        if parent_i != parent_j:
            parent[parent_i] = parent_j
