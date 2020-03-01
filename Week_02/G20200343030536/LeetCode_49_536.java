import java.util.*;

/**
 * @author : Hyuk
 * @description : LeetCode_49_536
 * @date : 2020/2/21 4:42 下午
 */
public class LeetCode_49_536 {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String key = String.valueOf(ch);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }

            StringBuilder key = new StringBuilder();
            for (int i = 0; i < 26; ++i) {
                key.append(count[i]);
            }

            if (!map.containsKey(key.toString())) { map.put(key.toString(), new ArrayList<>()); }
            map.get(key.toString()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
