/*
 * @lc app=leetcode.cn id=8 lang=cpp
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
class Solution {
public:
    int myAtoi(string str) {
        const int slen = str.size();
        if (slen == 0) return 0; // 空字符串
        int i = 0; // str的下标
        while (i < slen && str[i] == ' ') ++i; // 跳过空格
        if (i >= slen) return 0;
        char c = str[i];
        bool minus = false;
        if (c == '-') {
            minus = true;
            ++i;
        } else if (c == '+') ++i;
        int v = 0;
        bool valid = false;
        while (i < slen && str[i] >= '0' && str[i] <= '9') {
            valid = true;
            int u = str[i] - '0';
            if (v < INT32_MIN / 10 || v * 10 < INT32_MIN + u) return minus ? INT32_MIN : INT32_MAX;
            v = v * 10 - u;
            ++i;
        }
        if (!valid) return 0;
        if (minus) return v;
        if (v == INT32_MIN) return INT32_MAX;
        return -v;
    }
};

// @lc code=end

