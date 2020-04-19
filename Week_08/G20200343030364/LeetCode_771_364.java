/**
 * Created by HuGuodong on 4/6/20.
 */
public class LeetCode_771_364 {

  class Solution {

    public int numJewelsInStones(String J, String S) {
      if (J.length() == 0 || S.length() == 0) return 0;
      char[] jewels = J.toCharArray();
      char[] stones = S.toCharArray();
      int[] jTypes = new int[52];
      for (char c : jewels) {
        if (c >= 'a' && c <= 'z') jTypes[c - 'a']++;
        else jTypes[c - 'A' + 26]++;
      }
      int sum = 0;
      for (char c : stones) {
        if ((c >= 'a' && c <= 'z' && jTypes[c - 'a'] > 0) || (c >= 'A' && c <= 'Z'
            && jTypes[c - 'A' + 26] > 0)) sum++;
      }
      return sum;
    }
  }
}
