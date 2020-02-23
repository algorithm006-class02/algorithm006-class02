import java.util.ArrayList;
import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 *
 * https://leetcode-cn.com/problems/group-anagrams/description/
 *
 * algorithms
 * Medium (60.43%)
 * Likes:    271
 * Dislikes: 0
 * Total Accepted:    51.5K
 * Total Submissions: 84.6K
 * Testcase Example:  '["eat","tea","tan","ate","nat","bat"]'
 *
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 
 * 示例:
 * 
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ⁠ ["ate","eat","tea"],
 * ⁠ ["nat","tan"],
 * ⁠ ["bat"]
 * ]
 * 
 * 说明：
 * 
 * 
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> strMap = new HashMap<>();

        for (String str : strs){
            char[] strChar = str.toCharArray();
            Arrays.sort(strChar);
            String key = new String(strChar);
            if(!strMap.containsKey(key)){
                strMap.put(key, new ArrayList<>());
            }
            strMap.get(key).add(str);
        }

        return new ArrayList<>(strMap.values());
       
        
    }
}
// @lc code=end

