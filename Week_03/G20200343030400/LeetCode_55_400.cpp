//55
//https://leetcode-cn.com/problems/jump-game

class Solution {
public:
    bool canJump(vector<int>& nums) {
        int numsSize = nums.size();
        int curRange = 0;
        for (int i = 0; i < numsSize; i++) {
            curRange = max(curRange - 1, nums[i]);
            if (curRange >= numsSize - 1 - i)
                return true;
            if (curRange == 0)
                return false;    
        }
        return false;
    }
}; 
