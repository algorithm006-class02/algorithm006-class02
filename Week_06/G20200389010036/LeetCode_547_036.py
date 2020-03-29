class Solution:
    def findCircleNum(self, M: List[List[int]]) -> int:
        def find(node):
            if circles[node] == node: return node
            root = find(circles[node])
            circles[node] = root
            return root
        
        n = len(M)
        circles = {x:x for x in range(n)}
        num = n
        for i in range(n):
            for j in range(i, n):
                if i != j and M[i][j] == 1 and find(i) != find(j):
                    circles[find(i)] = find(j)   
                    
        return sum([1 for k, v in circles.items() if k == v])