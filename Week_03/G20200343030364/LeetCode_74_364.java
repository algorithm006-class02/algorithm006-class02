/**
 * Created by HuGuodong on 3/2/20.
 */
public class LeetCode_74_364 {

  class Solution {

    public boolean searchMatrix(int[][] a, int target) {
      if (a.length == 0) return false;
      int m = a.length, n = a[0].length;
      int lo = 0, hi = m * n - 1;

      while (lo <= hi) {
        int mid = lo + (hi - lo) / 2;
        int i = mid / n;
        int j = mid % n;
        int mid_val = a[i][j];
        if (target == mid_val) {
          return true;
        }
        else if (target < mid_val) {
          hi = mid - 1;
        }
        else {
          lo = mid + 1;
        }
      }
      return false;
    }

  }
}
