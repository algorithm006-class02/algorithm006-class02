class Solution
{
public:
    vector<int> twoSum(vector<int> &nums, int target)
    {
        std::unordered_map<int, int> hashmap;
        for (int i = 0; i < nums.size(); i++)
        {
            int expect_value = target - nums[i];
            if (hashmap.find(expect_value) != hashmap.end())
            {
                return {i, hashmap[expect_value]};
            }

            hashmap[nums[i]] = i;
        }

        return {};
    }
};