

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        Map<Character, Character> cache = new HashMap<>();
        cache.put('(', ')');
        cache.put('[', ']');
        cache.put('{', '}');
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (cache.containsKey(aChar)) {
                stack.push(aChar);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character left = stack.pop();
                if (cache.get(left) != aChar) {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}