class Solution {
public:
    //动态规划--状态数组为二维数组，第二维表示第i个房子是偷还是不偷，0表示不偷，1表示偷
    int rob(vector<int>& nums) {
        if(nums.empty())
            return 0;
        vector<vector<int>> dp(nums.size(),vector<int>(2));
        dp[0][0] = 0;       //如果第0个房子不偷的话，那么所得财物自然就是最少的0了
        dp[0][1] = nums[0];       //如果第1个房子要偷的话，那么所得财物就是第0个房子里的钱了
        
        for(int i = 1; i < nums.size(); ++i)
        {
            //如果第i个房子不偷的话，那么可以偷i减1个房子，看i-1是偷还是不偷的收益大
            dp[i][0] = max(dp[i - 1][0],dp[i - 1][1]);
            //如果第i个房子要偷的话，那么就不能偷第i-1个房子了，因为会触发报警
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return max(dp[nums.size() - 1][0],dp[nums.size() - 1][1]);
    }
};
