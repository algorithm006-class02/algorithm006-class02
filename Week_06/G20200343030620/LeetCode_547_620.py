class Solution:
    def findCircleNum(self, M: List[List[int]]) -> int:
        #思路1：使用并查集的思路实现,时间复杂度为O(n)
        # a. 建立n*n的子集  b. 遍历M中的朋友关系进行union操作 c. union 时候涉及到集合关系的查找uion find 操作 d.统计朋友圈的关系量
        #思路2：使用BFS 进行遍历 o(n^2）
        if not M:
            return 0
        res=0
        parent=[i for i in range(len(M))]
        def find(parent,root):
            while parent[root]!=root:
                root=parent[root]
            return root

        def union(parent,i,j):
            x=find(parent,i)
            y=find(parent,j)
            if x!=y :
                parent[x]=y
            
        for i in range(len(M)):
            for j in range(i+1,len(M[i])):
                if M[i][j]==1 and i !=j:
                    union(parent,i,j)

        for i in range(len(M)):
            if i==parent[i]:
                res+=1
        return res                                      