//26
//https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array

class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if (nums.size() == 0)
            return 0;
        int uniques = 1;
        int check = nums[0];
        for (int i = 1; i < nums.size(); ++i) {
            if (nums[i] != check) {
                if (i > uniques) {
                    nums[uniques] = nums[i];
                }
                check = nums[i];
                ++uniques;
            }
        }
        return uniques;
    }
};
