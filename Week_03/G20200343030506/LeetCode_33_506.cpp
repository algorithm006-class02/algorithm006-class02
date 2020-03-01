/*
 * @lc app=leetcode.cn id=33 lang=cpp
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
public:
    int search(vector<int>& nums, int target) {
        int l=0, r=nums.size()-1, mid=(l+r)/2;
        if(nums.empty())
            return -1;

        while(l<=r){
            if(target==nums[mid])
                return mid;
            if (nums[l] > nums[r]) {
                if (nums[mid] < nums[r]) {
                    if (target<nums[mid] || target>nums[r])
                        r = mid - 1;
                    else
                        l = mid + 1;
                }
                else {
                    if (target > nums[mid] || target < nums[l])
                        l = mid + 1;
                    else
                        r = mid - 1;
                }
            }
            else {
                if (nums[mid] > target)
                    r = mid - 1;
                else
                    l = mid + 1;
            }
            mid=(l+r)/2;
        }
        return -1;
    }
};
// @lc code=end

