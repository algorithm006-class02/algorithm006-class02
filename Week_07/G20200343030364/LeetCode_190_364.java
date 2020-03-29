/**
 * Created by HuGuodong on 3/29/20.
 */
public class LeetCode_190_364 {

  public class Solution {

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
      int ans = 0;
      for (int i = 0; n != 0 && i < 32; i++, n >>= 1) {
        ans += (n & 1) << (31 - i);
      }
      return ans;
    }
  }
}
