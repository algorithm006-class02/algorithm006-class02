package Week_02.G20200343030512;
import java.util.*;
import javax.xml.soap.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List> map = new HashMap<String, List>();
        for (String i : strs) {
            char[] arr = i.toCharArray();
            Arrays.sort(arr);

            String str = String.valueOf(arr);
            if (!map.containsKey(str)) {
                map.put(str, new ArrayList());
            }

            map.get(str).add(i);
        }

        return new ArrayList(map.values());
    }
}