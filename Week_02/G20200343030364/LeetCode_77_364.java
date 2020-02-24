import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by HuGuodong on 2/22/20.
 */
public class LeetCode_77_364 {

  class Solution {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
      if (n <= 0 || k <= 0 || n < k) return result;
      findComb(n, k, 1, new Stack<>());
      return result;
    }

    private void findComb(int n, int k, int begin, Stack<Integer> p) {
      if (p.size() == k) {
        result.add(new ArrayList<>(p));
        return;
      }
      for (int i = begin; i <= n; i++) {
        p.push(i);
        findComb(n, k, i + 1, p);
        p.pop();
      }
    }
  }
}
