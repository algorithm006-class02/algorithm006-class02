import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=438 lang=java
 *
 * [438] 找到字符串中所有字母异位词
 */

// @lc code=start
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int left = 0;
        int right = 0;
        int sLen = s.length();
        int pLen = p.length();
        int[] hash = new int[256];
        //统计出 p串中每个字符的出现频率 放入hash里
        List<Integer> pos = new ArrayList<Integer>();
        for (int i = 0; i < pLen; i++) {
            hash[(int) p.charAt(i)]++;
        }
        int count = 0;
        while (right < sLen) {
            if (hash[(int) s.charAt(right)] > 0) {
                hash[(int) s.charAt(right)]--;
                count++;
                right++;
            } else {
                hash[(int) s.charAt(left)]++;
                count--;
                left++;
            }
            if (count == pLen) {
                pos.add(left);
            }
        }
        return pos;
    }
}
// @lc code=end

