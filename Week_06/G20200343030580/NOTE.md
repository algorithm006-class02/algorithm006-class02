学习笔记


### 双向BFS模板

````
def TWOENDEDBFS(graph, start, end):
    visited = set()
	frontQueue = [] 
    endQueue = [] 
	frontQueue.append([start]) 
    endQueue.append([end])

	while frontQueue && endQueue: 
        switchIfNecessary(frontQueue, endQueue)

		node = frontQueue.pop() 
		visited.add(node)

		process(node) 
		nodes = generate_related_nodes(node) 

		frontQueue.push(nodes)

	# other processing work 
	...
````

### 130. 被围绕的区域 的非并查集解法
````
class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        if (n == 0) {
            return;
        }
        int m = board[0].length;
        boolean[][] pass = new boolean[n][m];
        for (int i = 0; i < m; i++) {
            search(board, 0, i, n, m, pass);
        }
        for (int i = 1; i < n; i++) {
            search(board, i, 0, n, m, pass);
        }
        for (int i = 0; i < m; i++) {
            search(board, n - 1, i, n, m, pass);
        }
        for (int i = 1; i < n; i++) {
            search(board, i, m - 1, n, m, pass);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pass[i][j] == false) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void search(char[][] grid, int i, int j, int n, int m, boolean[][] pass) {
        if (i < 0 || i == n || j < 0 || j == m) {
            return;
        }
        if (pass[i][j]) {
            return;
        }
        if (grid[i][j] == 'O') {
            pass[i][j] = true;
            int dx[] = {0, 0, -1, 1};
            int dy[] = {-1, 1, 0, 0};
            for (int k = 0; k < 4; k++) {
                search(grid, i + dx[k], j + dy[k], n, m, pass);
            }
        }
    }
}

````
