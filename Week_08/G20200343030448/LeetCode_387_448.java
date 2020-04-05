package G20200343030448;

import java.util.HashMap;

public class LeetCode_387_448 {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < len; i++) {
            if (charMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
