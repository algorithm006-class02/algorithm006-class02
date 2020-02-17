import java.util.Arrays;

/**
 * Created by HuGuodong on 2/17/20.
 */
public class LeetCode_242_364 {
  class Solution {

    // create an counter array to store alphabet frequency
    public boolean isAnagram_2(String s, String t) {
      if (s.length() != t.length()) return false;
      char[] arrS = s.toCharArray(), arrT = t.toCharArray();
      int[] counter = new int[26];
      for (int i = 0; i < arrS.length; i++) {
        counter[arrS[i] - 'a']++;
        counter[arrT[i] - 'a']--;
      }
      for (int cnt : counter)
        if (cnt != 0) return false;
      return true;
    }

    // s,t to char array, then sort array, compare each element
    public boolean isAnagram_1(String s, String t) {
      if (s.length() != t.length()) return false;
      char[] arrS = s.toCharArray(), arrT = t.toCharArray();
      Arrays.sort(arrS);
      Arrays.sort(arrT);
      return Arrays.equals(arrS, arrT);
    }
  }
}
