/**
 * Created by HuGuodong on 3/29/20.
 */
public class LeetCode_231_364 {

  class Solution {

    public boolean isPowerOfTwo(int n) {
      return n > 0 && (n & (n - 1)) == 0;
    }
  }
}
