/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0){
            return new ArrayList<>();
        }
        Map<String,List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String newStr = String.valueOf(c);
            if(!map.containsKey(newStr)){
                 map.put(newStr,new ArrayList<String>());
            }
            map.get(newStr).add(str);
        }
        return new ArrayList(map.values());
    }
}
// @lc code=end

