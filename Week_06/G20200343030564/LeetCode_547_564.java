package week06;

/**
 * 朋友圈
 *
 * 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。
 *
 * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
 *
 * 示例 1:
 *
 * 输入:
 * [[1,1,0],
 *  [1,1,0],
 *  [0,0,1]]
 * 输出: 2
 * 说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
 * 第2个学生自己在一个朋友圈。所以返回2。
 *
 *
 * 示例 2:
 *
 * 输入:
 * [[1,1,0],
 *  [1,1,1],
 *  [0,1,1]]
 * 输出: 1
 * 说明：已知学生0和学生1互为朋友，学生1和学生2互为朋友，所以学生0和学生2也是朋友，所以他们三个在一个朋友圈，返回1。
 */
public class LeetCode_547_564 {

    public static void main(String[] args) {
        LeetCode_547_564 leetCode = new LeetCode_547_564();
        System.out.println(leetCode.findCircleNum1(new int[][]{
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 0, 1, 1},
        }));
        System.out.println(leetCode.findCircleNum(new int[][]{
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 0, 1, 1},
        }));
    }

    /**
     * DFS
     * 时间复杂度：O(n^2)，整个矩阵都要被遍历，大小为 n^2
     * 空间复杂度：O(n) visited 数组的大小
     *
     * @param M
     * @return
     */
    public int findCircleNum1(int[][] M) {
        if (M == null || M[0].length == 0) return 0;

        int count = 0;
        // N * N 矩阵
        int[] visited = new int[M.length];
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dsf(M, visited, i);
                count++;
            }
        }
        return count;
    }

    private void dsf(int[][] m, int[] visited, int i) {
        for (int j = 0; j < m.length; j++) {
            if (m[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dsf(m, visited, j);
            }
        }
    }


    /**
     * 并查集
     * 时间复杂度：O(n^3)，访问整个矩阵一次，并查集操作需要最坏 O(n) 的时间
     * 空间复杂度：O(n)，parent 大小为 n
     *
     * @param M
     * @return
     */
    public int findCircleNum(int[][] M) {
        if (M == null || M[0].length == 0) return 0;

        UnionFind1 uf = new UnionFind1(M);

        int nr = M.length;
        int nc = M[0].length;
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (M[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.getCount();
    }
}

class UnionFind1 {

    private int count;

    private int[] parent;

    private int[] rank;


    // 1.构建并查集
    public UnionFind1(int[][] m){
        if (m == null || m.length == 0) return;

        int n = m.length;
        parent = new int[n];
        rank = new int[n];
        count = n;

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    // 2.查找并查集
    public int find(int i){
        if (parent[i] != i) parent[i] = find(parent[i]);
        return parent[i];
    }

    // 3.合并并查集
    public void union(int x, int y){
        // 查找父类信息
        int rootX = find(x);
        int rootY = find(y);

        // 合并
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootY] > rank[rootX]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }

            // 减少1
            count--;
        }
    }

    public int getCount(){
        return this.count;
    }
}
