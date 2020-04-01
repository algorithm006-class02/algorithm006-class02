class Solution {
public:
    //使用动态规划的方法求解
    string longestPalindrome(string s) {
        string result;
        int n = s.size();
        vector<vector<bool>>  dp(n,vector<bool>(n));  //这个dp数组表示的是dp[i][j]，下标为i和j的字符串是不是回文字符串
        
        //这个两层for循环的意思就是从中间开始向着两边扩散，检查[i,j]构成的字符串是不是回文字符串
        for ( int i = n - 1; i >=0; --i)
        {
            for ( int j = i; j < n ; ++j)
            {
                //j - i < 2，说明这是一个空串或者是只有一个字符的字符串，dp[i+1][j - 1]为真，说明dp[i][j]的子串也是回文串
                dp[i][j] = s[i] == s[j] && ( (j -i) < 2 || dp[i+1][j - 1]);
                
                //更新结果
                if(dp[i][j] && (j -i + 1) > result.size())
                    result = s.substr(i,j - i + 1);
            }
        }
        return result;
    }
};
