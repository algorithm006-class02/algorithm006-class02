/*
 * @lc app=leetcode.cn id=283 lang=cpp
 *
 * [283] 移动零
 * ### 解题思路
 * 第一种:  遍历所有的nums flag记录交换位置，遇到0就和flag换
 * 第二种:  遍历一边，所有的非0树往前移动，候补0 用index记录
 * ### 代码
 */

// @lc code=start
/* ----- 第一种
class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        for (int i= 0 , flag = 0; i < nums.size(); i++) {
            if (nums[i] != 0) {
                swap(nums[flag],nums[i]);
                flag++;
            }
        }
    }
};
 */

class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int idx = 0;
        for(int num: nums){
            if(num != 0) nums[idx++]=num;
        }
        while(idx < nums.size()) nums[idx++] = 0;
    }
};

// @lc code=end


