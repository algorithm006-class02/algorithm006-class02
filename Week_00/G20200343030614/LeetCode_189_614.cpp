class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        if (k>nums.size()) k%=nums.size();
        int len=nums.size();
        reverse(nums.begin(),nums.end()-k);
        reverse(nums.end()-k,nums.end());
        reverse(nums.begin(),nums.end());
    }
};