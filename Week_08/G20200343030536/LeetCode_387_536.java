/**
 * @author : Hyuk
 * @description : LeetCode_387_536
 * @date : 2020/4/5 2:33 下午
 */
public class LeetCode_387_536 {

    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) { return -1; }
        int[] arr = new int[26];
        for (int i = 0, len = s.length(); i < len; ++i) {
            arr[s.charAt(i) - 'a']++;
        }

        for (int i = 0, len = s.length(); i < len; ++i) {
            if (arr[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
