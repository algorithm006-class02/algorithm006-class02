//283-move-zeros

class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int count_nonzeros = 0;
        for (int i = 0; i < nums.size(); ++i) {
            if (nums[i] != 0) {
                if (i != count_nonzeros) {
                    nums[count_nonzeros] = nums[i];
                    nums[i] = 0;
                }
                ++count_nonzeros;
            }
        }
    }
};
