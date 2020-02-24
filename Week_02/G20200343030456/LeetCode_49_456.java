import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LeetCode_49 {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            //排序+map
            HashMap<String, List<String>> maps = new HashMap<String, List<String>>();
            for (String str : strs) {
                char[] ar = str.toCharArray();
                Arrays.sort(ar);
                String sorted = String.valueOf(ar);

                List<String> list = maps.get(sorted);
                if (list == null) {
                    list = new ArrayList<String>();
                    maps.put(sorted, list);
                }
                list.add(str);
            }
            return new ArrayList<List<String>>(maps.values());
        }
    }
}
