/*
 * @lc app=leetcode.cn id=1 lang=cpp
 *
 * [1] 两数之和
 * ### 解题思路
 * 第一种:  先将所有的数字遍历一边放在一个map中，然后在遍历一次时直接从map里面查找
 * 第二种:  一边遍历一边放这个数的差值，后面遍历的时看map里面有没有，有就是存在。
 * ### 代码
 */
// @lc code=start
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        map<int, int> m;
        for(int i = 0; i < nums.size(); m[target - nums[i - 1]] = i++){
            if(m.count(nums[i])) return {m[nums[i]], i};
        }
        return {-1, -1};
    }
};
// @lc code=end

