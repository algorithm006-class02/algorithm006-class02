class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        if(nums.empty())
            return 0;
        if(1 == nums.size())
            return nums[0];
        int maxSum = nums[0];
        for(int i = 1; i < nums.size(); ++i)
        {
            if(nums[i - 1] > 0)
                nums[i] += nums[i - 1];     //改变了nums[i]，nums就是dp数组，nums[i]中保存的就是子序和
            maxSum = maxSum > nums[i] ? maxSum : nums[i];
        }
        return maxSum;
    }
};
