/*
 * @lc app=leetcode.cn id=860 lang=cpp
 *
 * [860] 柠檬水找零
 */

// @lc code=start
class Solution {
public:
    bool lemonadeChange(const vector<int>& bills) {
        int five = 0, ten = 0;
        for (const auto& bill : bills)
            if (bill == 5) five++;
            else if (bill == 10 && 0 < five) --five, ++ten;
            else if (0 < ten && 0 < five) --five, --ten;
            else if (2 < five) five-=3;
            else return false;
        return true;
    }
};

// @lc code=end

