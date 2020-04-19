/**
 * @author : Hyuk
 * @description : LeetCode_541_536
 * @date : 2020/4/5 2:40 下午
 */
public class LeetCode_541_536 {

    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        int len = s.length();
        for (int i = 0; i < len; i += 2 * k) {
            int start = i, end = Math.min(len - 1, i + k - 1);
            while (start < end) {
                char tmp = ch[start];
                ch[start] = ch[end];
                ch[end] = tmp;
                start++;
                end--;
            }
        }
        return String.valueOf(ch);
    }
}
