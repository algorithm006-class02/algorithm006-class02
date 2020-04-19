class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        if (nums.size()==0) return 0;
        if (nums.size()==1) return 1;
        int n = nums.size();
        vector<int> dp(n, 0);
        for (int i=0; i<n; i++) {
            dp[i] = 1;
            for (int j=0; j<i; j++) {
                if (nums[j]<nums[i]) {
                    dp[i] = max(dp[i], dp[j]+1);
                }
            }
        }
        return *max_element(dp.begin(), dp.end());
    }
};