import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Solution {
    Map<Character, char[]> mapping = new TreeMap<Character, char[]>();

    {
        mapping.put('2', new char[]{'a','b','c'});
        mapping.put('3', new char[]{'d','e','f'});
        mapping.put('4', new char[]{'g','h','i'});
        mapping.put('5', new char[]{'j','k','l'});
        mapping.put('6', new char[]{'m','n','o'});
        mapping.put('7', new char[]{'p','q','r','s'});
        mapping.put('8', new char[]{'t','u','v'});
        mapping.put('9', new char[]{'w','x','y','z'});
    }

    List<String> output = new ArrayList<String>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0){
            return output;
        }

        combinationsHelp(digits, 0, new StringBuilder());
        return output;
    }

    public void combinationsHelp(String digists, int start, StringBuilder result){
        if (start == digists.length()){
            output.add(result.toString());
            return;
        }

       char[] mapchar = mapping.get(digists.charAt(start));
        for (int i = 0; i < mapchar.length; i++) {
            result.append(mapchar[i]);
            combinationsHelp(digists, start + 1, result);
            result.deleteCharAt(result.length() - 1);
        }
    }
}