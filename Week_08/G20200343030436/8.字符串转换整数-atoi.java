/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String str) {
        char[] chars = str.toCharArray();
        int n = chars.length;
        int idx = 0;
        
        //1. Empty string
        while (idx < n && chars[idx] == ' ') {
            idx++;
        }
        if (idx == n) {
            return 0;
        }
        // Handle signs
        boolean negative = false;
        if (chars[idx] == '-') {
            negative = true;
            idx++;
        } else if(chars[idx] == '+') {
            idx++;
        } else if (!Character.isDigit(chars[idx])) {
            return 0;
        }
        int ans = 0;
        //4. Convert number and avoid overflow
        while (idx < n && Character.isDigit(chars[idx])) {
            int digit = chars[idx] - '0';
            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans * 10 + digit;
            idx++;
        }
        return negative ? -ans : ans;
          
    }


}
// @lc code=end

