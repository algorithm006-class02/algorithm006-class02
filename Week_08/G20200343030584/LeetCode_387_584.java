package week8;

import java.util.HashMap;
import java.util.Map;

/**
 * 387. 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 * 案例:
 * s = "leetcode"
 * 返回 0.
 * <p>
 * s = "loveleetcode",
 * 返回 2.
 * <p>
 * 注意事项：您可以假定该字符串只包含小写字母。
 * <p>
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 */
public class FirstUniqChar {
    public static void test() {
//        String s = "leetcode";
        String s = "loveleetcode";
        System.out.println("不重复字符位置：" + new FirstUniqChar().firstUniqChar(s));
    }

    public int firstUniqChar(String s) {
        // 通过hashmap，字母为索引，出现的次数为value
        Map<Character, Integer> map = new HashMap<>(26);
        char[] chars = s.toCharArray();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == 1) {
                return i;
            }
        }
        return -1;
    }

    public int firstUniqChar2(String s) {
        for (int i = 0; i < s.toCharArray().length; i++) {
            char ch = s.charAt(i);
            if (s.indexOf(ch) == s.lastIndexOf(ch)) {
                return i;
            }
        }
        return -1;
    }

    public int firstUniqChar3(String s) {
        // 数组，字符直接对应数组下标（最快）
        int[] counts = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            counts[c - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (counts[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public int firstUniqChar4(String s) {
        // 遍历26个字母，比较只出现一次字母的位置，取最小值（较快）
        int pos = s.length();
        for (char i = 'a'; i <= 'z'; i++) {
            int index = s.indexOf(i);
            if (index != -1 && index == s.lastIndexOf(i)) {
                // 该字符只出现一次
                pos = Math.min(pos, index);
            }
        }
        return (pos >= 0 && pos < s.length()) ? pos : -1;
    }

    public int firstUniqChar5(String s) {
        // 遍历26个字母，比较只出现一次字母的位置，取最小值（最快）
        int pos = -1;
        for (char i = 'a'; i <= 'z'; i++) {
            int index = s.indexOf(i);
            if (index != -1 && index == s.lastIndexOf(i)) {
                // 该字符只出现一次
                if (pos == -1 || pos > index) {
                    pos = index;
                }
            }
        }
        return pos;
    }
}
