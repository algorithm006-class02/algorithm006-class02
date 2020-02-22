import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
class Solutiona {

    private static final Map<Character, Character> match_maps = new HashMap<Character, Character>() 
    {
        {
            put('(', ')');
            put('{', '}');
            put('[', ']');
            put('@', '@');
        }
    };
    public boolean isValid(String s) {

        Deque<Character> stack = new LinkedList<Character>();
        stack.addLast('@');
        for (char c : s.toCharArray()) {
            if (match_maps.containsKey(c)) {
                stack.addLast(c);
            } else if (match_maps.get(stack.removeLast()) != c) {
                return false;
            }
        }
        return stack.size() == 1;
    }

}