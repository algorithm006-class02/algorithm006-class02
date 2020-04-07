package week08;

import java.util.ArrayList;
import java.util.List;

/**
 * 找到字符串中所有字母异位词
 *
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 *
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 *
 * 说明：
 *
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 示例 1:
 *
 * 输入:
 * s: "cbaebabacd" p: "abc"
 *
 * 输出:
 * [0, 6]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 *  示例 2:
 *
 * 输入:
 * s: "abab" p: "ab"
 *
 * 输出:
 * [0, 1, 2]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 *
 */
public class LeetCode_438_564 {

    public static void main(String[] args) {
        LeetCode_438_564 leetCode= new LeetCode_438_564();
        System.out.println(leetCode.findAnagrams("cbaebabacd", "abc"));
    }

    /**
     * 数组
     * 时间复杂度：O()
     * 空间复杂度：O(1)
     *
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        if(s == null || s.length() == 0) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        int[] needs = new int[26];
        int[] windows = new int[26];
        int left = 0, right = 0;
        int valid = p.length();

        // 循环p到needs中
        for (char c : p.toCharArray()) needs[c - 'a']++;

        while (right < s.length()) {
            // 如果p包含s的右边字母
            char cha = s.charAt(right);
            if (needs[cha- 'a'] > 0) {
                // 加入到滑动窗口中
                windows[cha- 'a']++;
                if (windows[cha- 'a'] <= needs[cha- 'a']) valid--;
            }

            while (valid == 0) {
                if (right - left + 1 == p.length()) res.add(left);
                // 如果长度不够就要缩短串口，看看当前左边的值还在不在滑动窗口中
                char ch = s.charAt(left);
                if(needs[ch - 'a'] > 0) {
                    windows[ch - 'a']--;
                    if (windows[ch - 'a'] < needs[ch - 'a']) valid++;
                }
                left++;
            }

            right++;
        }
        return res;
    }
}
