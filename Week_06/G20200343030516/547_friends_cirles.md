547. 朋友圈
班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。

给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。

示例 1:

输入: 
[[1,1,0],
 [1,1,0],
 [0,0,1]]
输出: 2 
说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
第2个学生自己在一个朋友圈。所以返回2。
示例 2:

输入: 
[[1,1,0],
 [1,1,1],
 [0,1,1]]
输出: 1
说明：已知学生0和学生1互为朋友，学生1和学生2互为朋友，所以学生0和学生2也是朋友，所以他们三个在一个朋友圈，返回1。

### solution
dfs
```python
# dfs
class Solution:
    def findCircleNum(self, M: List[List[int]]) -> int:
        m = len(M)
        res =  0
        visited  = [0 for i in range(m)]
        def helper(i):
            for j in range(m):
                if visited[j]== 0 and M[i][j]==1:
                    visited[j] = 1
                    helper(j)

        for i in range(m):
            if visited[i] == 0:
                res+=1
                helper(i)

        return res

```
bfs
```python
class Solution:
    def findCircleNum(self, M: List[List[int]]) -> int:
        visited =set()
        m = len(M)
        res = 0
        for i in range(m):
            if i not in visited:
                visited.add(i)
                queue = [i]
                while queue:
                    s = queue.pop(0)
                    for j in range(m):
                        if j not in visited and M[s][j] == 1:
                            queue.append(j)
                            visited.add(j)
                res +=1
        return res  
```