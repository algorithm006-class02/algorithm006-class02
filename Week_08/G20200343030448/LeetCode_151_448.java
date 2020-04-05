package G20200343030448;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LeetCode_151_448 {
    public String reverseWords(String s) {
        List<String> wordList = Arrays.asList(s.trim().split(" +"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }
}
