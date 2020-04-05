import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_387_422 {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        char[] chars = s.toCharArray();
        Map<Character, Integer> charsPositions = new HashMap<Character, Integer>();
        List<Integer> uniqsPositions = new ArrayList<Integer>();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (charsPositions.containsKey(c)) {
                Integer charFirstPosition = charsPositions.get(c);
                uniqsPositions.remove(charFirstPosition);
            } else {
                charsPositions.put(c, i);
                uniqsPositions.add(i);
            }
        }
        return uniqsPositions.isEmpty() ? -1 : uniqsPositions.get(0);
    }
}
