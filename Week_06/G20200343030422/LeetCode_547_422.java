import java.util.HashSet;
import java.util.Set;

public class LeetCode_547_422 {
    public int findCircleNum(int[][] M) {
        if (M.length == 0 || M[0].length == 0) {
            return 0;
        }
        int row = M.length, column = M[0].length;
        UnionFind uf = new UnionFind(row);
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < row; i++) {
            for (int j = i + 1; j < column; j++) {
                if (M[i][j] == 1) {
                    uf.unite(i, j);
                }
            }
        }
        for (int i = 0; i < row; i++) {
            uf.f[i] = uf.find(i);
            set.add(uf.f[i]);
        }
        return set.size();
    }

    class UnionFind {
        int[] f;

        public UnionFind(int size) {
            f = new int[size];
            for (int i = 0; i < size; i++) {
                f[i] = i;
            }
        }

        public int find(int x) {
            if (f[x] != x) {
                f[x] = find(f[x]);
            }
            return f[x];
        }

        public void unite(int x, int y) {
            int fx = find(x);
            int fy = find(y);
            f[f[y]] = fx;
        }
    }
}
