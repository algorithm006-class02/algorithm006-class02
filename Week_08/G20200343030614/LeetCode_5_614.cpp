class Solution {
public:
    string longestPalindrome(string s) {
        if (s.size()<=1) return s;
        int len = s.size();
        vector<vector<int>>  dp(len,vector<int>(len));
        int start = 0;    //回文串起始位置
        int max = 1;      //回文串最大长度
        for (int i=0; i<len; i++) {
            dp[i][i] = 1;
            if (i<len-1 && s[i]==s[i+1]) {
                dp[i][i+1] = 1;
                max = 2;
                start = i;
            }
        }
        for (int l=3; l<=len; l++) {
            for (int i=0; i+l-1<len; i++) {
                int j=l+i-1;
                if (s[i]==s[j]&&dp[i+1][j-1]==1) {
                    dp[i][j] = 1;
                    start = i;
                    max = l;
                }
            }
        }
        return s.substr(start, max);
    }
};