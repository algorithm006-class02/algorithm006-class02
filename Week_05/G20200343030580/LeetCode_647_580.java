class Solution {
    public int countSubstrings(String s) {
        int l = s.length();
        boolean[][] opt = new boolean[l][l];
        int result = 0;
        for (int i = l - 1; i > -1; i--) {
            for (int j = i; j < l ; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || opt[i + 1][j - 1] == true)) {
                    opt[i][j] = true;
                    result++;
                }
            }
        }
        return result;
    }
}
