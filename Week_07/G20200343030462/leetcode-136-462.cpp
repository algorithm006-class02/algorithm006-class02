class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int result = 0;
        for(auto value : nums)
            result ^= value;
        return result;
    }
};
