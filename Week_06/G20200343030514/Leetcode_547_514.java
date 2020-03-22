class Solution {
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) {
            return 0;
        }
        
        UnionFind unionFind = new UnionFind(M.length);
        // 循环的范围很重要，去除自己，并且相当于只循环一个三角形区域，因为这个矩阵是对称的，并且对角线肯定为1（自己和自己）
        for (int i = 0; i < M.length - 1; i++) {
            for (int j = i + 1; j < M.length; j++) {
                if (M[i][j] == 1) {
                   unionFind.join(i, j);
                }
            }
        }
        return unionFind.getCount();
        
        
    }
    
    class UnionFind {
        private int count;
        private int[] parents;
        
        public UnionFind(int n) {
            this.count = n;
            this.parents = new int[n];
            for (int i = 0; i < n; i++) {
                this.parents[i] = i;
            }
        }
        
        public int findParent(int x) {
            while (parents[x] != x) {
                x = parents[x];        
            }
            return x;
        } 
        
        public void join(int x, int y) {
            int px = findParent(x);
            int py = findParent(y);
            if (px != py) {
                parents[px] = py;
                this.count--;
            }
        }
        
        public int getCount() {
            return this.count;
        }
    }
}
