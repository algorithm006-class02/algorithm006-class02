public class LeetCode_91_590 {
    public int numDecodings(String s) {

        if(s == null || s.length() == 0) {
            return 0;
        }

        // DP array to store the subproblem results
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        // Ways to decode a string of size 1 is 1. Unless the string is '0'.
        // '0' doesn't have a single digit decode.
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for(int i = 2; i < dp.length; i += 1) {

            // Check if successful single digit decode is possible.
            if(s.charAt(i-1) != '0') {
                dp[i] += dp[i-1];
            }

            // Check if successful two digit decode is possible.
            int twoDigit = Integer.valueOf(s.substring(i-2, i));
            if(twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[s.length()];

    }
}
