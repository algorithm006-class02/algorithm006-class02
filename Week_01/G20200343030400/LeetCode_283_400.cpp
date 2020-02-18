//283
//https://leetcode-cn.com/problems/move-zeroes

class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int nonzeros = 0;
        for (int i = 0; i < nums.size(); ++i) {
            if (nums[i] != 0) {
                if (i > nonzeros) {
                    nums[nonzeros] = nums[i];
                    nums[i] = 0;
                }
                ++nonzeros;
            }
        }
    }
};
