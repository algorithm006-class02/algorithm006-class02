/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        int[] needs = new int[128];
        int[] window = new int[128];
        for (char c : t.toCharArray()) {
            needs[c] = needs[c] + 1;
        }
        int left = 0, right = 0;
        int tLen = t.length();
        int count = 0;
        int minLength = s.length() + 1;
        String result = "";
        while (right < s.length()) {
            char ch = s.charAt(right);
            window[ch] = window[ch] + 1;
            if (needs[ch] > 0 && needs[ch] >= window[ch]) {
                count++;
            }
            while (count == tLen) {
                ch = s.charAt(left);
                if (needs[ch] > 0 && needs[ch] >= window[ch]) {
                    count--;
                }
                if ((right - left) + 1 < minLength) {
                    minLength = (right - left) + 1;
                    result = s.substring(left, right + 1);
                }
                window[ch] = window[ch] - 1;
                left++;
            }
            right++;
        }
        return result;
    }
}
// @lc code=end

