/**
 * https://leetcode-cn.com/problems/valid-anagram/
 * @author : Hyuk
 * @description : LeetCode_242_536
 * @date : 2020/3/29 10:22 下午
 */
public class LeetCode_242_536 {

    public boolean isAnagram(String s, String t) {
        if (s == t) { return true; }
        if (s.length() != t.length()) { return false; }
        int[] arr = new int[26];
        for (int i = 0, len = s.length(); i < len; ++i) {
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; ++i) {
            if (arr[i] != 0) { return false; }
        }
        return true;
    }

}
