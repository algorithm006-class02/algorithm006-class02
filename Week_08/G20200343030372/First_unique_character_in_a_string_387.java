package G20200343030372;

/**
 * @author Chen.C
 * @date 2020/4/1
 */
public class First_unique_character_in_a_string_387 {

    public int firstUniqChar(String s) {
        int n = s.length();
        for (int i = 'a'; i <= 'z'; i++) {
            int start = s.indexOf(i);
            int end = s.lastIndexOf(i);
            if (start == end && start != -1) {
                n = Math.min(start, n) ;
            }
        }
        return n == s.length() ? -1 : n;
    }
}
