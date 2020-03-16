package G20200343030448;

public class LeetCode_91_448 {
    public int numDecodings(String s) {
        //用数组的DP
        /*if (s == null) return 0;
        int len = s.length();
        if (len == 0) return 0;
        int[] dp = new int[len + 1];
        dp[len] = 1;
        dp[len - 1] = s.charAt(len - 1) == '0' ?  0 :  1;
        for (int i = len-2; i >=0 ; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
            } else if ((s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0') > 26) {
                dp[i] = dp[i + 1];
            } else {
                dp[i] = dp[i + 1] + dp[i + 2];
            }
        }
        return dp[0];*/

        //节约空间的DP, 用2个int哦，不是3个。
        if (s == null) return 0;
        int len = s.length();
        if (len == 0) return 0;
        int prior, after = 1;
        prior = s.charAt(len - 1) == '0' ?  0 :  1;
        for (int i = len-2; i >=0 ; i--) {
            if (s.charAt(i) == '0') {
                after = prior;
                prior = 0;
            } else if ((s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0') > 26) {
                after = prior;
            } else {
                prior += after;
                after = prior - after;
            }
        }
        return prior;
    }
}
