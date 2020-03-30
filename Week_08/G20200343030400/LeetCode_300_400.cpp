class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        vector<int> minimum;
        for (int num : nums) {
            if (!minimum.size() || num > minimum.back()) {
                minimum.push_back(num);
            } else {
                *lower_bound(minimum.begin(), minimum.end(), num) = num;
            }
        }
        return minimum.size();
    }
};
