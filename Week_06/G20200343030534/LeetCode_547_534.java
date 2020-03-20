package com.test.datastructure;

public class FriendCircles547 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        FriendCircles547 test = new FriendCircles547();
        int[][] input = {
                { 1, 1, 0 },
                { 1, 1, 0 },
                { 0, 0, 1 }
        };
        System.out.println(test.findCircleNum(input));
    }

    public int findCircleNum(int[][] M) {
        int m = M.length;
        int count = 0;
        int[] parent = new int[m];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (M[i][j] == 1) {
                    union(i, j, parent);
                }

            }
        }
        for(int i = 0; i < m; i++) {
            if(i == parent[i]) ++count;
        }
        return count;
    }

    private void union(int p, int q, int[] parent) {
        int rootP = find(p, parent);
        int rootQ = find(q, parent);
        if (rootP == rootQ)
            return;
        parent[rootP] = rootQ;
    }

    private int find(int p, int[] parent) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
}
