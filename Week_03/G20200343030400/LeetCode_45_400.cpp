//45
//https://leetcode-cn.com/problems/jump-game-ii/

class Solution {
public:
    int jump(vector<int>& nums) {
        int numsSize = nums.size();
        if (numsSize <= 1) {
            return 0;
        }
        bool reachedLast = false;
        int jumps = 0;
        int first = 0;
        int last = first;
        while (!reachedLast) {
            jumps++;
            int newFirst = numsSize;
            int newLast = first;
            for (int pos = first; pos <= last; pos++) {
                int minRange = pos + min(1, nums[pos]);
                int maxRange = pos + nums[pos];
                if (minRange <= numsSize - 1 && maxRange >= numsSize - 1) {
                    reachedLast = true;
                    break;
                }
                newFirst = min(newFirst, minRange);
                newLast = max(newLast, maxRange);
            }
            first = newFirst;
            last = newLast;
        }
        return jumps;
    }
};
