/**
 * Created by HuGuodong on 3/29/20.
 */
public class LeetCode_191_364 {

  public class Solution {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
      int num = 0;
      while (n != 0) {
        n = n & (n - 1);
        num++;
      }
      return num;
    }
  }
}
