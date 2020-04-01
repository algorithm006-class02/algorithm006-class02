class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 0) {
            return s;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        int[] index = new int[2];
        int maxStep = 0;
        for (int i = s.length() - 1; i > -1; i--) {
            for (int j = i; j < s.length(); j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1]);
                if (dp[i][j] == true && j - i > maxStep) {
                    index[0] = i;
                    index[1] = j;
                    maxStep = j - i;
                }
            }
        }
        return s.substring(index[0], index[1] + 1);
    }
}