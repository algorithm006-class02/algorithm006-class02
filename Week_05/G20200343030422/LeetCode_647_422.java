public class LeetCode_647_422 {
    public int countSubstringsDP(String s) {
        int n = s.length();
        if (n < 2) {
            return n;
        }
        int count = n;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i + 1 < n; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                count++;
            }
        }
        for (int len = 2; len < n; len++)
        {
            for (int i = 0; i + len < n; i++) {
                int j = i + len;
                if ((s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    count++;
                }
            }
        }
        return count;
    }

    public int countSubstringsNotDP(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += countSubstringsNotDP(s, i, i) + countSubstringsNotDP(s, i, i + 1);
        }
        return count;
    }

    private int countSubstringsNotDP(String s, int start, int end) {
        int count = 0;
        while (start >= 0 && end < s.length() && s.charAt(start--) == s.charAt(end++)) {
            count++;
        }
        return count;
    }
}
