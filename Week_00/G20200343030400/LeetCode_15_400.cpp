// 15
// https://leetcode-cn.com/problems/3sum/

class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        vector<vector<int>> ans;
        int size = nums.size();
        if (size < 3) return ans;
        sort(nums.begin(), nums.end());
        for (int i = 0; i < size - 2; ++i) {
            int a = nums[i];
            if (a > 0) break;
            if (i > 0 && a == nums[i - 1]) continue;
            int left = i + 1;
            int right = size - 1;
            while (left < right) {
                int b = nums[left];
                int c = nums[right];
                int sum = a + b + c;
                if (sum == 0) {
                    ans.push_back(vector<int>({a, b, c}));
                    while (left < right && b == nums[left]) ++left;
                    while (left < right && c == nums[right]) --right;
                } else if (sum < 0) {
                    ++left;
                } else {
                    --right;
                }
            } 
        }
        return ans;
    }
};
