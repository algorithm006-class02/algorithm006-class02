int longestValidParentheses(char *s) {
    if ((!s) || (strlen(s) < 2)) 
        return 0; 
    int i, sLen = strlen(s), maxNum = 0; 
    int *dp = (int*)calloc(sLen, sizeof(int)); 
    /*
     * dp[i]表示i位置字符参与匹配时，[0:i]的匹配长度。
     * s[0]不管是啥，都不能独自匹配，因此dp[0]=0;
     */
    for (i = 1; i < sLen; i++) {
        //'('没法作为结尾匹配, 所以dp[i] = 0, dp初始化的时候已经为0了，所以这里不再考虑
        if (')' == s[i]) {  
            //')', 看前一个位置s[i-1]
            if ('(' == s[i - 1]) 
                dp[i] = (i > 1) ? (dp[i - 2] + 2) : 2; 
            else {
                /* s[i]和s[i-1]均为')', dp[i-1]为已匹配的长度，往前倒退dp[i-1]个位置后，看s[i - 1 - dp[i - 1]] */ 
                if ((i - 1 - dp[i - 1] >= 0) && ('(' == s[i - 1 - dp[i - 1]])) 
                    dp[i] = dp[i - 1] + 2 + ((i - 1 - dp[i - 1] - 1 >= 0) ? dp[i - 1 - dp[i - 1] - 1] : 0); 
            }
            maxNum = (dp[i] > maxNum) ? dp[i] : maxNum; 
        } 
    }
    return maxNum; 
}
