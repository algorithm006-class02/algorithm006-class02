import java.util.Stack;

/**
 * Created by HuGuodong on 2/15/20.
 */
public class LeetCode_20_364 {
  class Solution {

    public boolean isValid(String s) {
      Stack<Character> stack = new Stack<Character>();
      for (char c : s.toCharArray()) {
        if (c == '(') stack.push(')');
        else if (c == '{') stack.push('}');
        else if (c == '[') stack.push(']');
        else if (stack.isEmpty() || stack.pop() != c) return false;
      }
      return stack.isEmpty();
    }
  }
}
