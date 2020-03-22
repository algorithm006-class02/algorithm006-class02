//二分查找
class Solution {
public:
    int findMin(vector<int>& nums) {
        if (nums.size()==1) return nums[0];
        int low=0, high=nums.size()-1;
        while (low<high) {
            int mid = low + (high-low)/2;
            if (nums[mid]<=nums[high]) {
                high = mid;
            } else {
                low = mid+1;
            }
        }
        return nums[high];
    }
};