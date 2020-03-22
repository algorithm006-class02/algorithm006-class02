/**
 * https://leetcode-cn.com/problems/friend-circles/
 * @author : Hyuk
 * @description : LeetCode_547_536
 * @date : 2020/3/22 6:32 下午
 */
public class LeetCode_547_536 {

    public int findCircleNum(int[][] M) {
        int n = M.length;
        int[] parent = new int[n];
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (M[i][j] == 1 && i != j) {
                    union(parent, i , j);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < n; ++i) {
            if (parent[i] == i) {
                res++;
            }
        }
        return res;
    }

    private int find(int[] parent, int i) {
        if (parent[i] == i) {
            return i;
        }
        return find(parent, parent[parent[i]]);
    }

    private void union(int[] parent, int x, int y) {
        int parentX = find(parent, x);
        int parentY = find(parent, y);
        parent[parentX] = parentY;
    }

}
