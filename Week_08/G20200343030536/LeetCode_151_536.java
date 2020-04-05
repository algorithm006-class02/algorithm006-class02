import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author : Hyuk
 * @description : LeetCode_151_536
 * @date : 2020/4/5 7:11 下午
 */
public class LeetCode_151_536 {

    public String reverseWords(String s) {
        if (s == null) { return null; }
        s = s.trim();
        List<String> list = Arrays.asList(s.split("\\s+"));
        Collections.reverse(list);
        return String.join(" ", list);
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode_151_536().reverseWords("a b c"));
    }
}
