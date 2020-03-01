import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by HuGuodong on 2/22/20.
 */
public class LeetCode_429_364 {
  class Solution {
    public List<List<Integer>> levelOrder(Node root) {
      List<List<Integer>> res = new ArrayList<>();
      if (root == null) return res;
      Queue<Node> que = new LinkedList<>();
      que.add(root);
      while (!que.isEmpty()) {
        int size = que.size();
        List<Integer> level = new LinkedList<>();
        for (int i = 0; i < size; i++) {
          Node n = que.poll();
          level.add(n.val);
          que.addAll(n.children);
        }
        res.add(level);
      }
      return res;
    }
  }
}
