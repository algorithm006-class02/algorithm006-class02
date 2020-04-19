class Solution {
public:
    int numDistinct(string s, string t) {
        int s_size = s.size(), t_size = t.size();
        vector<long> dp(s_size + 1, 1);
        for (auto c : t) {
            auto last = dp[0];
            dp[0] = 0;
            for (int j = 0; j < s_size; ++j) {
                auto record = dp[j+1];
                if (s[j] == c) dp[j+1] = last + dp[j];
                else dp[j+1] = dp[j];
                last = record;
            }
        }
        return dp.back();
    }
};