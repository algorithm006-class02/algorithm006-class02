//26
//https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array

class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if (nums.size() == 0 )
            return 0;
        int uniques = 0;
        for (int i = 1; i < nums.size(); ++i) {
            if (nums[i] != nums[uniques]) {
                ++uniques;
                nums[uniques] = nums[i];
            }
        }
        return (uniques + 1);
    }
};
