class Solution {
    public int numDecodings(String s) {
        if(s == null || s.equals("")) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int[] dp = new int[2];
        int curNum = 0;
        dp[0] = 1;
        int tmp = 0;
        for(int i = 1 ; i < chars.length + 1 ; i ++) {
            if(chars[i - 1] == '0' && i == 1) {
                return 0;
            } else if(i == 1 && chars[i - 1] != '0') {
                dp[i] = 1;
            } else if(chars[i - 1] == '0' && chars[i - 2] != '1' && chars[i - 2] != '2') {
                return 0;
            } else if(chars[i - 1] == '0' && (chars[i - 2] == '1' || chars[i - 2] == '2')){
                tmp = dp[0];
                dp[0] = dp[1];
                dp[1] = tmp;
            } else if(chars[i - 2] > '2' || (chars[i - 2] == '2' && chars[i - 1] > '6')) {
                dp[0] = dp[1];
            } else if(chars[i - 2] == '0' && chars[i - 1] != '0') {
                dp[0] = dp[1];
            } else {
                tmp = dp[0] + dp[1];
                dp[0] = dp[1];
                dp[1] = tmp;
            }
        }

        return dp[1];
    }
}