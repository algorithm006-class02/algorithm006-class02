import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=387 lang=java
 *
 * [387] 字符串中的第一个唯一字符
 */

// @lc code=start
class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char temp = s.charAt(i);
            count.put(temp, count.getOrDefault(temp, 0) + 1);
        }

        for (int i = 0; i < len; i++) {
            if (count.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
// @lc code=end

