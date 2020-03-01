import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LeetCode_49_378 {
    //排序法
    public List<List<String>> groupAnagramsI(String[] strs) {

        HashMap<String, List<String>> groupMap = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!groupMap.containsKey(key))
                groupMap.put(key, new ArrayList<>());
            groupMap.get(key).add(s);
        }
        return new ArrayList<>(groupMap.values());
    }

    //基数法
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> hashMap = new HashMap<>();
        int[] count = new int[26];

        for (String s : strs) {
            Arrays.fill(count, 0);
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < count.length; i++) {
                sb.append(count[i]);
            }
            String key = sb.toString();

            if (!hashMap.containsKey(key)) {
                hashMap.put(key,new ArrayList());
            }
            hashMap.get(key).add(s);
        }
        return new ArrayList<>(hashMap.values());
    }

}
