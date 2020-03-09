class Solution
{
public:
    int findMin(vector<int> &nums)
    {
        int start = 0;
        int end = nums.size() - 1;

        while (start < end)
        {
            if (nums[start] < nums[end])
                return nums[start];

            int mid = start + (end - start) / 2;
            if (nums[mid] >= nums[start])
            {
                start = mid + 1;
            }
            else
            {
                end = mid;
            }
        }

        return nums[start];
    }
};