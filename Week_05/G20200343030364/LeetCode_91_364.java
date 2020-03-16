import java.util.HashMap;
import java.util.Map;

/**
 * Created by HuGuodong on 3/11/20.
 */
public class LeetCode_91_364 {

  class Solution {

    Map<Integer, Integer> map = new HashMap<>();

    public int numDecodings(String s) {
      if (s.equals("0")) return 0;
      if (s.indexOf("0") == 0) return 0;
      return helper(0, s);
    }

    private int helper(int pos, String s) {
      if (pos >= s.length()) {
        return 1;
      }
      // mem
      if (map.containsKey(pos)) return map.get(pos);
      int step1 = 0;
      if (pos + 1 <= s.length() && Integer.valueOf(s.substring(pos, pos + 1)) > 0)
        step1 = helper(pos + 1, s);
      int step2 = 0;
      if (isValid(s, pos)) step2 = helper(pos + 2, s);
      // mem
      map.put(pos, step1 + step2);
      return step1 + step2;
    }

    private boolean isValid(String s, int pos) {
      if (pos + 2 <= s.length() && s.substring(pos, pos + 2).indexOf("0") != 0) {
        int val = Integer.valueOf(s.substring(pos, pos + 2));
        if (val > 0 && val < 27) {
          return true;
        }
      }
      return false;
    }
  }
}
