char * longestPalindrome(char * s) {
    if (!s) 
        return NULL; 
    int i, right, len = strlen(s), maxLen = 1, maxStart = 0; 
    if (len < 2)
        return s; 
    int **dp = calloc(len, sizeof(int*)); 
    for (i = 0; i < len; i++) {
        dp[i] = calloc(len, sizeof(int)); 
        dp[i][i] = 1; 
    }
    for (right = 1; right < len; right++) 
        for (i = 0; i < right; i++) {
            if ((s[i] == s[right]) && ((right - i <= 2) || dp[i + 1][right - 1])) {
                dp[i][right] = 1; 
                if (right - i + 1 > maxLen) {
                    maxLen = right - i + 1; 
                    maxStart = i; 
                }
            }
        }

    s[maxStart + maxLen] = '\0'; 
    return (s + maxStart); 
}
