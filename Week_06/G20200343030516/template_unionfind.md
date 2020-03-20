并查集模板：

```java
class UnionFind {
    private int count  = 0;
    private int[] parent;
    public UnionFind(int n){
        count = n;
        parent = new int[n];
        for (int i = 0; i< n; i++){
            parent[i] = i;
        }
    }
    public int find(int p){
        while(p != parent[p]){
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public void union(int p, int q){
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP == rootQ) return
        parent[rootP] = rootQ;
        count--;
    }
}
```


```python
def init(p):
p = [i for i in range(n)]
def union(self,p,i,j):
    p1 = self.parent(p,i)
    p2 = self.parent(p,j)
    p[p1] = p2

def parent(self,p,i):
    root = i
    while root != p[root]:
        root =  p[root]
    while p[i] != i:
        x = i
        i = p[i]
        p[x] = root
    return root

```

```python
class Solution:
    def findCircleNum(self, M: List[List[int]]) -> int:
        m = len(M) 
        p = [i for i in range(m) ]

        def get_parent(i):
            root = i
            while root != p[root]:
                root =  p[root]
            while p[i] != i:
                x = i
                i = p[i]
                p[x] = root
            return root

        def union(i,j):
            x = get_parent(i)
            y = get_parent(j)
            if x != y:
                p[x]  = y

        for i in range(m):
            for j in range(m):
                if M[i][j] == 1 and i!=j:
                    union(i,j)
        
        res = 0
        for i in range(m):
            if i == p[i]:
                res+=1
        return res 
            
```