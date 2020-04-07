/**
 * Created by HuGuodong on 4/6/20.
 */
public class LeetCode_58_364 {

  class Solution {

    public int lengthOfLastWord(String s) {
      if (s.length() == 0) return 0;
      int len = 0, tail = s.length() - 1;
      while (tail >= 0 && s.charAt(tail) == ' ') tail--;
      while (tail >= 0 && s.charAt(tail) != ' ') {
        len++;
        tail--;
      }
      return len;
    }
  }
}
