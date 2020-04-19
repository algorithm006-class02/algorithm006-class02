class Solution {
public:
    int totalNQueens(int n) {
        int cnt = 0;
        int size = (1 << n) - 1;
        dfs(n, 0, 0, 0, 0, cnt);
        return cnt;
    }

    void dfs(int& n, int row, int cols, int diffs, int sums, int& cnt) {
        if (row == n) {
            cnt++;
            return;
        }

        int bits = (~(cols | diffs | sums)) & ((1 << n) - 1);

        while (bits) {
            int p = bits & -bits;
            bits = bits & (bits - 1);
            dfs(n, row + 1, cols | p, (diffs | p) << 1, (sums | p) >> 1, cnt);
        }
    }
};
