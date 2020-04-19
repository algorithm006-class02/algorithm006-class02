/**
 * Created by HuGuodong on 4/6/20.
 */
public class LeetCode_709_364 {

  class Solution {

    public String toLowerCase(String s) {
      char[] chs = s.toCharArray();
      for (int i = 0; i < chs.length; i++) {
        if (chs[i] >= 'A' && chs[i] <= 'Z') chs[i] = (char) (chs[i] - 'A' + 'a');
      }
      return String.valueOf(chs);
    }
  }
}
