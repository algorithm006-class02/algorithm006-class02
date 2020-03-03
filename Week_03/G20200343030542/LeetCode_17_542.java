
import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {

    String[] letterMap = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        search(digits, 0, "", result);
        return result;
    }

    private void search(String digits, int index, String tempStr, List<String> list) {
        if (index == digits.length()) {
            list.add(tempStr);
            return;
        }
        int pos = digits.charAt(index) - '0';
        String str = letterMap[pos];
        for (int i = 0; i < str.length(); i++) {
            search(digits, index + 1, tempStr + str.charAt(i), list);
        }
    }

}
