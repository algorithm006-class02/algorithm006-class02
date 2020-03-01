//55
//https://leetcode-cn.com/problems/jump-game

class Solution {
public:
    bool canJump(vector<int>& nums) {
        int numsSize = nums.size();
        if (0 == numsSize) return false;
        if (1 == numsSize) return true;
        int curRange = 0;
        for (int i = 0; i < numsSize - 1; i++) {
            curRange = max(curRange - 1, nums[i]);
            if (curRange == 0)
                return false;
            if (curRange >= numsSize - 1)
                return true;
        }
        return (curRange > 0);
    }
}; 
