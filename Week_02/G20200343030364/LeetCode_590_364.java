import java.util.LinkedList;
import java.util.List;

/**
 * Created by HuGuodong on 2/22/20.
 */
public class LeetCode_590_364 {

  class Solution {

    public List<Integer> postorder(Node root) {
      LinkedList<Node> stack = new LinkedList<>();
      LinkedList<Integer> output = new LinkedList<>();
      if (root == null) {
        return output;
      }

      stack.add(root);
      while (!stack.isEmpty()) {
        Node node = stack.pollLast();
        output.addFirst(node.val);
        for (Node item : node.children) {
          if (item != null) {
            stack.add(item);
          }
        }
      }
      return output;
    }
  }
}
