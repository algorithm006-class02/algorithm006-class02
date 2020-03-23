class Solution {
    public int findCircleNum(int[][] M) {
        int peopleCount = M.length;

        UnionFind unionFind = new UnionFind(peopleCount);
        for (int i = 0; i < peopleCount; i++){
            for (int j = 0; j <= i; j++){
                if (i == j) continue;
                if (M[i][j] == 1) unionFind.union(i, j);
            }
        }

        int[] arr = unionFind.parent;
        int count = 0;
        for (int i = 0; i < peopleCount; i++){
            if (arr[i] == -1){
                count++;
            }
        }

        return count;
    }


    class UnionFind{
        private int[] parent;
        private int[] rank;

        public UnionFind(int size){
            this.parent = new int[size];
            this.rank = new int[size];
            for (int i = 0; i < size; i++){
                parent[i] = -1;
                rank[i] = 1;
            }
        }

        // 更新到每个节点都指向根节点
        public int find(int p){
            if (parent[p] == -1) return p; // 如果p的父节点是-1表示当前p就是根节点

            int curP = p;
            while (parent[p] != -1){ // 循环找到根节点
                p = parent[p];
            }

            parent[curP] = p; // 将查找的节点指向根节点，以减低树的高度，起到后续查询时优化的作用
            return p;
        }

        public boolean isConnected(int p, int q){
            return find(p) == find(q);
        }

        public void union(int p, int q){
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot == qRoot) return;

            if (rank[pRoot] > rank[qRoot]){
                parent[qRoot] = pRoot;
            }else if (rank[pRoot] < rank[qRoot]){
                parent[pRoot] = qRoot;
            }else{
                parent[qRoot] = pRoot;
                rank[pRoot] += 1;
            }
        }
    }
}