//45
//https://leetcode-cn.com/problems/jump-game-ii/

class Solution {
public:
    int jump(vector<int>& nums) {
        int numsSize = nums.size();
        int jumps = 0;
        int curRange = 0;
        int maxRange = 0;
        for (int pos = 0; pos < numsSize -1; pos++) {
            maxRange = max(maxRange, pos + nums[pos]);
            if (pos == curRange) {
                curRange = maxRange;
                jumps++;
            }
        }
        return jumps;
    }
};
