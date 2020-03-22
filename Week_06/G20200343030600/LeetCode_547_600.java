/**
 * 547. 朋友圈
 */

public class LeetCode_547_600 {
    public int findCircleNum(int[][] M) {
        //1. 将N名学生加入并查集，各自独立集合
        //2. 遍历M，M[i][j] --> union
        //3. 返回孤立的集合数
        UF uf = new UF(M.length);
        for(int i = 0; i < M.length; i++) {
            for(int j = 0; j < M[0].length; j++) {
                if(M[i][j] == 1)
                    uf.union(i, j);
            }
        }
        return uf.count;
    }

    class UF {
        private int count = 0;
        private int[] parent;

        public UF(int n) {
            count = n;
            parent = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int i) {
            while(parent[i] != i) {
                parent[i] = parent[parent[i]];
                i = parent[i];
            }
            return i;
        }

        public void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if(rootI == rootJ) return;
            parent[rootI] = rootJ;
            count--;
        }
    }

    public static void main(String[] args) {
        int[][] M = {{1,1,0}, {1,1,0}, {0,0,1}};
        LeetCode_547_600 sol = new LeetCode_547_600();
        System.out.println(sol.findCircleNum(M));
    }
}
