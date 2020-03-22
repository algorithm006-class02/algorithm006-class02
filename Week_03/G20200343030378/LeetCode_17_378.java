import java.util.*;

public class LeetCode_17_378 {
    public List<String> letterCombinations(String digits) {
        if(null == digits || 0 == digits.length() )
            return new ArrayList<>();
        Map<Character, String> map = new HashMap<Character, String>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> ret = new ArrayList<>();

        helper("",ret,digits,0,map);

        return ret;

    }

    private void helper(String s, List<String> ret, String digits, int index, Map<Character, String> map) {
        // termintor
        if(index == digits.length()){
            ret.add(s);
            return;
        }

        String s1 = map.get(digits.charAt(index));
        for(int i = 0;i<s1.length();i++){
            //process + dirll down
            helper(s+s1.charAt(i),ret,digits,index+1,map);
        }
    }
}
