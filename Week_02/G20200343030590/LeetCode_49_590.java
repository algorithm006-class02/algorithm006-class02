import java.util.*;

public class LeetCode_49_590 {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map= new HashMap<>();
        int[] counter = new int[26];
        for (String str : strs) {
            Arrays.fill(counter, 0);
            for (char c : str.toCharArray()) counter[c - 'a']++;

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                // divide each chars
                sb.append('#');
                sb.append(counter[i]);
            }
            String key = sb.toString();
            // insert into bins, same group must be in the same bin
            if (!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList(map.values());
    }
}
