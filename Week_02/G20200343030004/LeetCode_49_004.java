import java.util.*;

public class LeetCode_49_004 {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<List<String>>();
        Map<String,ArrayList<String>> map = new HashMap<>();
        for(String str:strs) {
            char[] strChars = str.toCharArray();
            Arrays.sort(strChars);
            String key = new String(strChars);

            ArrayList<String>  arrayList =  map.get(key);
            if(arrayList == null) {
                arrayList = new ArrayList<>();
            }
            arrayList.add(str);
            map.put(key,arrayList);
        }
        return new ArrayList<>(map.values());
    }
}
