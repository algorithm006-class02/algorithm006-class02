import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by HuGuodong on 2/14/20.
 */
public class LeetCode_15_364 {

  class Solution {

    public List<List<Integer>> threeSum(int[] num) {
      Arrays.sort(num);
      List<List<Integer>> res = new LinkedList<>(); // 不需要动态扩容，速度更快
      for (int i = 0; i < num.length - 2; i++) {
        if (num[i] > 0) break;
        if (i > 0 && num[i] == num[i - 1]) continue;
        int lo = i + 1, hi = num.length - 1, sum = -num[i];
        while (lo < hi) {
          if (sum == num[lo] + num[hi]) {
            res.add(Arrays.asList(num[i], num[lo], num[hi]));
            while (lo < hi && num[lo] == num[lo + 1]) lo++;
            while (lo < hi && num[hi] == num[hi - 1]) hi--;
            lo++;
            hi--;
          }
          else if (sum > num[lo] + num[hi]) lo++;
          else hi--;
        }
      }
      return res;
    }
  }
}
