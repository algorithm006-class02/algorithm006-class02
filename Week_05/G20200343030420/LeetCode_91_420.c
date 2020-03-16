/**
 * 对于"str" + 'c', str为已经处理过的字符串，c为正在处理的字符。
 * 对于str所有的编码分两种情况: 编码最后一个为单字符，记为X; 编码最后一个为双字符，记为XY
 * 现在看正在处理的c，和前面的编码的组合有：[..., X, c], [..., XY, c], [..., Xc].
 * 上述想法是通过数学归纳法递推而来。另外要考虑字符‘0’的特殊情况。 
 * 定义状态空间dp[i][j], i为正在处理的字符位置，j：0表示编码最后一个为单字符，1表示编码最后一个为双字符
 */ 
int numDecodings(char * s) {
    int len = strlen(s), i, res; 
    int **dp = calloc(len, sizeof(int*)); 
    for (i = 0; i < len; i++) 
        dp[i] = calloc(2, sizeof(int)); 

    if ('0' == s[0]) 
        return 0; 
    dp[0][0] = 1; 
    dp[0][1] = 0; 
    for (i = 1; i < len; i++) {
        if ('0' == s[i]) {
            /* 只能和单字符('1' or '2')的去组合成双字符 */             
            if (('1' != s[i - 1]) && ('2' != s[i - 1])) 
                return 0; 
            dp[i][0] = 0; 
            dp[i][1] = dp[i - 1][0]; 
        } 
        else {
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1]; 
            if (('1' == s[i - 1]) || (('2' == s[i - 1]) && (s[i] <= '6'))) 
                dp[i][1] = dp[i - 1][0]; 
            else 
                dp[i][1] = 0; 
        }
    }
    res = dp[len - 1][0] + dp[len - 1][1]; 
    for (i = 0; i < len; i++) 
        free(dp[i]); 
    free(dp); 
    return res; 
}
