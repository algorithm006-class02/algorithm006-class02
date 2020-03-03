import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by HuGuodong on 2/22/20.
 */
public class LeetCode_144_364 {

  class Solution {

    public List<Integer> preorderTraversal(TreeNode node) {
      List<Integer> res = new ArrayList<>();
      Stack<TreeNode> stack = new Stack<>();
      while (node != null) {
        res.add(node.val);
        if (node.right != null) stack.push(node.right);
        node = node.left;
        if (node == null && !stack.isEmpty()) {
          node = stack.pop();
        }
      }
      return res;
    }
  }
}
