import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by HuGuodong on 2/22/20.
 */
public class LeetCode_49_364 {

  class Solution {

    public List<List<String>> groupAnagrams(String[] a) {
      if (a.length == 0) return new ArrayList();
      Map<String, List<String>> ans = new HashMap<>();
      for (String s : a) {
        char[] ca = s.toCharArray();
        Arrays.sort(ca);
        String key = String.valueOf(ca);
        if (ans.get(key) == null) {
          ans.put(key, new ArrayList());
        }
        ans.get(key).add(s);
      }
      return new ArrayList(ans.values());
    }
  }
}
