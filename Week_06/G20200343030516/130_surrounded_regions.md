130. 被围绕的区域
给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。

找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。

示例:

X X X X
X O O X
X X O X
X O X X
运行你的函数后，矩阵变为：

X X X X
X X X X
X X X X
X O X X
解释:

被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。


### solution
dfs + recursion
```python
class Solution:
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if not board or not board[0]:return 
        m,n = len(board),len(board[0])

        def helper(i,j):
            if i < 0 or i > m-1 or 0>j or j>n-1 or board[i][j]=="#"or board[i][j] == "X":
                return
            board[i][j] = "#"
            helper(i-1,j)
            helper(i+1,j)
            helper(i,j-1)
            helper(i,j+1)

        for i in range(m):
            for j in range(n):
                if i in [0,m-1] or j in [0,n-1]:
                    if board[i][j] == "O":
                        helper(i,j)

        for i in range(m):
            for j in range(n):
                if board[i][j] == "O":
                    board[i][j] = "X"
                if board[i][j] == "#":
                    board[i][j] = "O"
```


并查集
并查集:
并查集这种数据结构好像大家不太常用，实际上很有用，我在实际的 production code 中用过并查集。并查集常用来解决连通性的问题，即将一个图中连通的部分划分出来。当我们判断图中两个点之间是否存在路径时，就可以根据判断他们是否在一个连通区域。 而这道题我们其实求解的就是和边界的 OO 在一个连通区域的的问题。

并查集的思想就是，同一个连通区域内的所有点的根节点是同一个。将每个点映射成一个数字。先假设每个点的根节点就是他们自己，然后我们以此输入连通的点对，然后将其中一个点的根节点赋成另一个节点的根节点，这样这两个点所在连通区域又相互连通了。
并查集的主要操作有：

+ find(int m)：这是并查集的基本操作，查找 mm 的根节点。

+ isConnected(int m,int n)：判断 m，nm，n 两个点是否在一个连通区域。

+ union(int m,int n):合并 m，nm，n 两个点所在的连通区域。

```java
class UnionFind {
    int[] parents;

    public UnionFind(int totalNodes) {
        parents = new int[totalNodes];
        for (int i = 0; i < totalNodes; i++) {
            parents[i] = i;
        }
    }
		// 合并连通区域是通过find来操作的, 即看这两个节点是不是在一个连通区域内.
    void union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);
        if (root1 != root2) {
            parents[root2] = root1;
        }
    }

    int find(int node) {
        while (parents[node] != node) {
            // 当前节点的父节点 指向父节点的父节点.
            // 保证一个连通区域最终的parents只有一个.
            parents[node] = parents[parents[node]];
            node = parents[node];
        }

        return node;
    }

    boolean isConnected(int node1, int node2) {
        return find(node1) == find(node2);
    }
}

// 我们的思路是把所有边界上的 OO 看做一个连通区域。遇到 OO 就执行并查集合并操作，这样所有的 OO 就会被分成两类

// 和边界上的 OO 在一个连通区域内的。这些 OO 我们保留。
// 不和边界上的 OO 在一个连通区域内的。这些 OO 就是被包围的，替换。
// 由于并查集我们一般用一维数组来记录，方便查找 parants，所以我们将二维坐标用 node 函数转化为一维坐标。

public void solve(char[][] board) {
        if (board == null || board.length == 0)
            return;

        int rows = board.length;
        int cols = board[0].length;

        // 用一个虚拟节点, 边界上的O 的父节点都是这个虚拟节点
        UnionFind uf = new UnionFind(rows * cols + 1);
        int dummyNode = rows * cols;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    // 遇到O进行并查集操作合并
                    if (i == 0 || i == rows - 1 || j == 0 || j == cols - 1) {
                        // 边界上的O,把它和dummyNode 合并成一个连通区域.
                        uf.union(node(i, j), dummyNode);
                    } else {
                        // 和上下左右合并成一个连通区域.
                        if (i > 0 && board[i - 1][j] == 'O')
                            uf.union(node(i, j), node(i - 1, j));
                        if (i < rows - 1 && board[i + 1][j] == 'O')
                            uf.union(node(i, j), node(i + 1, j));
                        if (j > 0 && board[i][j - 1] == 'O')
                            uf.union(node(i, j), node(i, j - 1));
                        if (j < cols - 1 && board[i][j + 1] == 'O')
                            uf.union(node(i, j), node(i, j + 1));
                    }
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (uf.isConnected(node(i, j), dummyNode)) {
                    // 和dummyNode 在一个连通区域的,那么就是O；
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    int node(int i, int j) {
        return i * cols + j;
    }
}
```