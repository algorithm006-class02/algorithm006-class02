import java.util.HashSet;
import java.util.Set;

/**
 * Created by HuGuodong on 2/29/20.
 */
public class LeetCode_874_364 {
  class Solution {
    public int robotSim(int[] cmds, int[][] obstacles) {
      int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
      int x = 0, y = 0, d = 0, max = 0;
      Set<String> set = new HashSet<>();
      for (int[] o : obstacles) set.add(o[0] + "," + o[1]);
      for (int c : cmds) {
        if (c == -1) d = (d + 1) % 4;
        else if (c == -2) d = (d + 3) % 4;
        else {
          while (c-- > 0 && !set.contains((x + dirs[d][0]) + "," + (y + dirs[d][1]))) {
            x += dirs[d][0];
            y += dirs[d][1];
            max = Math.max(x * x + y * y, max);
          }
        }
      }
      return max;
    }
  }
}
