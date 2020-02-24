import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        new Solution().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        Map<String, List<String>> mapping = new HashMap<String, List<String>>();

        for (String str : strs) {
            char[] strA = str.toCharArray();
            Arrays.sort(strA);

            List<String> r = mapping.getOrDefault(new String(strA), new ArrayList<String>());
            r.add(str);
            mapping.put(new String(strA), r);
        }
        result.addAll(mapping.values());
        return result;
    }
}