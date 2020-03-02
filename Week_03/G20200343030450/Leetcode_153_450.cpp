class Solution {
public:
    int bs(vector<int>& nums, int begin, int end) {
        if (end - begin == 1) return nums[begin];
        int mid = (end + begin) / 2;
        if (nums[mid - 1] > nums[mid]) {
            return nums[mid];
        } else if (nums[mid] > nums[nums.size() - 1]) {
            return bs(nums, mid, end);
        } else {
            return bs(nums, begin, mid);
        }
    }
    
    int findMin(vector<int>& nums) {
        return bs(nums, 0, nums.size());
    }
};