import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by HuGuodong on 2/22/20.
 */
public class LeetCode_589_364 {

  class Solution {

    public List<Integer> preordeßr(Node root) {
      LinkedList<Integer> result = new LinkedList<>();
      if (root == null) return result;
      Stack<Node> stack = new Stack<>();
      stack.push(root);
      while (!stack.isEmpty()) {
        Node cur = stack.pop();
        result.add(cur.val);
        Collections.reverse(cur.children);
        for (Node c : cur.children) {
          stack.push(c);
        }
      }
      return result;
    }
  }
}

