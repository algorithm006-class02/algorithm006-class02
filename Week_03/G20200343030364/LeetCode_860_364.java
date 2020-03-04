/**
 * Created by HuGuodong on 2/27/20.
 */
public class LeetCode_860_364 {

  class Solution {

    public boolean lemonadeChange(int[] bills) {
      int[] nums = new int[3];
      for (int b : bills) {
        if (b == 5) {
          nums[0]++;
        }
        else if (b == 10) {
          nums[1]++;
          nums[0]--;
        }
        else {
          nums[2]++;
          if (nums[1] > 0) {
            nums[1]--;
            nums[0]--;
          }
          else {
            nums[0] -= 3;
          }
        }
        if (nums[0] < 0 || nums[1] < 0) return false;
      }
      return true;
    }
  }
}
