class Solution {
    int res = 0;
    public int totalNQueens(int n) {
        Set<Integer> col = new HashSet<>();
        Set<Integer> z_diagonal = new HashSet<>();
        Set<Integer> f_diagonal = new HashSet<>();

        backtrack(0, n,col, z_diagonal, f_diagonal);
        return res;
    }
    private boolean backtrack(int i, int n,Set<Integer> col, Set<Integer> z_diagonal, Set<Integer> f_diagonal) {
        if (i == n) {
            return true;
        }
        for (int j = 0; j < n; j++) {
            if (!col.contains(j) && !z_diagonal.contains(i + j) && !f_diagonal.contains(i - j)) {
                col.add(j);
                z_diagonal.add(i + j);
                f_diagonal.add(i - j);
                if (backtrack(i+1,n,col,z_diagonal,f_diagonal)) res += 1;
                col.remove(j);
                z_diagonal.remove(i + j);
                f_diagonal.remove(i - j);
            }
        }
        return false;
    }
}
