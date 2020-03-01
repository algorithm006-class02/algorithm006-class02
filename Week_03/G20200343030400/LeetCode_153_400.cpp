//153
//https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array

class Solution {
public:
    int findMin(vector<int>& nums) {
        int left = 0;
        int right = nums.size() - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[left] <= nums[mid] && nums[mid] <= nums[right]) {
                return nums[left];
            } else if (nums[left] <= nums[mid] && nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                left++;
                right = mid;
            }
        }
        return nums[right];
    }
};
