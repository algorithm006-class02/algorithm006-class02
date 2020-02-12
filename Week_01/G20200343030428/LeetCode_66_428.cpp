/*
 * @lc app=leetcode.cn id=66 lang=cpp
 *
 * [66] 加一
 * ### 解题思路
 * 第一种:  从后往前遍历，是9就进一位，不是9就加1，最后判断是不是进位了。
 * 第二种:  digits.insert(digits.begin(),1); 优化了 
 *         digits[i] = digits[i] % 10; 优化了
 * ### 代码
 */
/*
class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        int end = digits.size() - 1;
        while (end-- > 0) {
            if(digits[end] + 1 == 10) {
                digits[end] = 0;
            }
            else {
                digits[end] = digits[end] +1;
                return digits;
            }
        }
        if (digits[0] == 0) {
            digits[0] = 1;
            digits.push_back(0);
        }
        return digits;
    }
};
 */
// @lc code=start
class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        for(int i = digits.size()-1;i>=0;i--){
            digits[i] ++;
            digits[i] = digits[i] % 10;
            if(digits[i] != 0)
                return digits;
        }
        digits.insert(digits.begin(),1);
        return digits;
    }
};
// @lc code=end

