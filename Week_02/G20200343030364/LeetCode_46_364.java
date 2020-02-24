import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by HuGuodong on 2/23/20.
 */
public class LeetCode_46_364 {

  class Solution {

    public List<List<Integer>> permute(int[] a) {
      List<List<Integer>> res = new ArrayList<>();
      if (a.length == 0) return res;
      boolean[] used = new boolean[a.length];
      Deque<Integer> path = new ArrayDeque<>();
      dfs(0, a, used, path, res);
      return res;
    }

    private void dfs(int level, int[] a, boolean[] used, Deque<Integer> path,
        List<List<Integer>> res) {
      if (path.size() == a.length) {
        res.add(new ArrayList<>(path));
        return;
      }
      for (int i = 0; i < a.length; i++) {
        if (!used[i]) {
          if(i>0 && a[i-1]==a[i] &&!used[i-1]) continue;
          used[i] = true;
          path.addLast(a[i]);
          dfs(level + 1, a, used, path, res);
          path.removeLast();
          used[i] = false;
        }
      }
    }
  }
}
