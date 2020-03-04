class Solution {
public:
    //贪心算法求解
    bool canJump(vector<int>& nums) {
        if(nums.empty())
            return false;
        
        int iCanReachable = nums.size() - 1;    //它记录的是从当前位置出发，它能够跳跃到的位置，初始值就是最后一个位置，也就是题目的终点，你站在原地不动，那自然是可以跳到原地的（题目要求数组中的元素是非负整数）
        
        for(int i = nums.size() - 1; i >= 0; --i)
        {
            //nums[i] + i，nums[i]表示的是你在i位置上可以跳跃的最大数目，那么以i位置为起点，跳跃nums[i]步结果大于或等于iCanReachable，说明你是能够从i位置跳跃到iCanReachable
            if(nums[i] + i >= iCanReachable)
            {
                iCanReachable = i;
            }
        }
        
        return 0 == iCanReachable;  //如果能从最后一个位置跳到0的话，说明问题是有解的
    }
};
