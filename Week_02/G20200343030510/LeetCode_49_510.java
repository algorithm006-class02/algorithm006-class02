import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (int i = 0; i<strs.length; i++){
            char[] str = strs[i].toCharArray();
            Arrays.sort(str);
            String key = String.valueOf(str);
            if (hashMap.containsKey(key)){
                hashMap.get(key).add(strs[i]);
            } else{
                List list = new ArrayList();
                list.add(strs[i]);
                hashMap.put(key,list);
            }

        }
        return new ArrayList<List<String>>(hashMap.values());
    }
}

