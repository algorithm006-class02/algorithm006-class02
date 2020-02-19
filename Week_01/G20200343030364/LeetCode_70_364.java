/**
 * Created by HuGuodong on 2/14/20.
 */
public class LeetCode_70_364 {

  class Solution {

    public int climbStairs(int n) {
      if (n <= 2) return n;
      int dp_1 = 1;
      int dp_2 = 2;
      for (int i = 3; i <= n; i++) {
        int temp = dp_2;
        dp_2 = dp_1 + dp_2;
        dp_1 = temp;
      }

      return dp_2;
    }
  }
}
