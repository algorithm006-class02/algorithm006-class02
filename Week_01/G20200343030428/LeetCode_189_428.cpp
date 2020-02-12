/*
 * @lc app=leetcode.cn id=189 lang=cpp
 *
 * [189] 旋转数组
 */
/* ----- 第一次提交 自己实现的overture 翻转函数
class Solution {
public:
    void overture(vector<int>& nums, int start, int end) {
        if (nums.size() == 1) return;
        for(; (end - start) > 0; start++, end--) {
            swap(nums[start], nums[end]);
        }
    }
    void rotate(vector<int>& nums, int k) {
        int skip = k % nums.size();
        overture(nums, 0, nums.size() - 1);
        overture(nums, 0, skip - 1);
        overture(nums, skip, nums.size() -1);
    }
};
*/
// ----- 最终提交

// @lc code=start
class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        int length = nums.size();
        k %= length;
        reverse(&nums[0], &nums[length]);
        reverse(&nums[0], &nums[k]);
        reverse(&nums[k], &nums[length]);
    }
};
// @lc code=end

