//二分查找
class Solution {
public:
    int search(vector<int>& nums, int target) {
        if (nums.size()==0) return -1;
        if (nums.size()==1) return nums[0]==target ? 0 : -1;
        int low=0,high=nums.size()-1;
        while (low<=high) {
            int mid = low + (high-low)/2;
            if (target==nums[mid]) {
                return mid;
            }
            if (nums[low]<=nums[mid]) {
                if (nums[low]<=target && target<=nums[mid]) {
                    high = mid;
                } else {
                    low = mid+1;
                }
            } else if (nums[mid+1]<=nums[high]){
                if (nums[mid+1]<=target && target<=nums[high]) {
                    low = mid+1;
                } else {
                    high= mid;
                }
            }
        }
        return -1;
    }
};