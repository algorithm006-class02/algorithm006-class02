class Solution {
public:
    int rob(vector<int>& nums) {
        if(nums.empty())
            return 0;
        if(1 == nums.size())
            return nums[0];
        if(2 == nums.size())
            return max(nums[0],nums[1]);
        int numberOfHouse = nums.size();
        //状态数组
        vector<vector<int>> dp(numberOfHouse,vector<int>(2));
        
        //一定不抢最后一间房子
        dp[0][0]= 0;        //第一间房子不抢
        dp[0][1] = nums[0];     //抢第一间房子
        //不考虑最后一间房子的情况
        for(int i = 1; i < numberOfHouse - 1; ++i)
        {
            //第i个房子不偷，那么第i- 1个房子偷和不偷找到一个最大值
            dp[i][0] = max(dp[i - 1][0],dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        
        int maxMoney = max(dp[numberOfHouse - 2][0],dp[numberOfHouse - 2][1]);
        
        //一定不抢第一间房子
        dp[1][0] = 0;
        dp[1][1] = nums[1];
        //不考虑第一间房子
        for(int i = 2; i < numberOfHouse; ++i)
        {
            dp[i][0] = max(dp[i-1][0],dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        
        return max(maxMoney,max(dp[numberOfHouse-1][0],dp[numberOfHouse-1][1]));
    }
};
