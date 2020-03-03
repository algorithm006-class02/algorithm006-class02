import java.util.*;

/**
 * @Description：
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
输出:
[
["ate","eat","tea"],
["nat","tan"],
["bat"]
]

 */
public class LeetCode_49_022 {
    /**
     *
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0){
            return new ArrayList();
        }
        Map<String, List<String>> map = new HashMap();
        for(String str : strs){
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String s = String.valueOf(c);
            if(!map.containsKey(s)){
                map.put(s,new ArrayList());
            }
            map.get(s).add(str);
        }
        return new ArrayList(map.values());
    }

}
