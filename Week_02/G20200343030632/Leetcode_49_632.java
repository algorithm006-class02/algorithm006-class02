import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 
        if (strs == null || strs.length == 0) {
            return new ArrayList<List<String>>();
        }
        Map<String, ArrayList<String>> helper = new HashMap<String, ArrayList<String>>();
        for (String s: strs) {
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            String key = String.valueOf(temp);
            if (!helper.containsKey(key)) {
                helper.put(key, new ArrayList<String>());
            }
            helper.get(key).add(s);
        }
        return new ArrayList<List<String>>(helper.values());
    }

}