class Solution
{
public:
    void rotate(vector<int> &nums, int k)
    {
        k = k % nums.size();
        std::reverse(nums.begin(), nums.end());
        std::reverse(nums.begin(), nums.begin() + k);
        std::reverse(nums.begin() + k, nums.end());
    }
};