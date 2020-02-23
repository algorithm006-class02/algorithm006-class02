import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 49. 字母异位词分组 
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 */

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> result = new HashMap<String, List<String>>();

        for (int i = 0; i < strs.length; i++) {

            char[] chars = strs[i].toCharArray();  
            Arrays.sort(chars);
            String sortedStr = String.valueOf(chars);

            List<String> list = result.get(sortedStr);
            if (list == null) {
                list = new ArrayList<String>();
            }
            list.add(strs[i]);
            result.put(sortedStr, list);
        }
        return new ArrayList(result.values());
    }
}