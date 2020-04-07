/**
 * @author : Hyuk
 * @description : LeetCode_242_536
 * @date : 2020/2/21 4:25 下午
 */
public class LeetCode_242_536_1 {

    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }

        int[] arrs = new int[26];
        int[] arrt = new int[26];
        for (int i = 0, len = s.length(); i < len; ++i) {
            arrs[s.charAt(i) - 'a']++;
            arrt[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; ++i) {
            if (arrs[i] != arrt[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode_242_536().isAnagram("nl", "cx"));
    }
}
