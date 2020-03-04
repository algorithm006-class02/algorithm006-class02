#include <vector>

using namespace std;

int search(vector<int>& nums, int target) {
    if(nums.empty())
        return -1;
    if(nums.size() == 1)
        return nums[0] == target ? 0 : -1;
    int left = 0;
    int right = nums.size() - 1;
    while(left <= right){
        int mid = left + (right - left) / 2;
        if(nums[mid] == target)
            return mid;
        if(nums[mid] >= nums[left]){ 
            if(target >= nums[left] && target < nums[mid]) //left --->mid 是单调递增的
                right = mid - 1;
            else
                left = mid + 1; 
        }
        else{
            if(target >nums[mid] && target <= nums[right]) //mid---right 单调递增的
                left = mid + 1;
            else
            {
                right = mid - 1;
            }
            
        }
    }
    return -1;
}