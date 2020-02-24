//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串


import java.util.*;
import java.util.stream.Collectors;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<String>> pool = new HashMap<>(strs.length);
        for (String element : strs) {
            int hashKey = hash(element);
            List<String> elementGroup;
            if ((elementGroup = pool.get(hashKey)) == null) {
                elementGroup = new LinkedList<String>();
                pool.put(hashKey, elementGroup);
            }
            elementGroup.add(element);
        }
        return new ArrayList<>(pool.values());
    }

    private int hash(String element) {
        int[] nums = new int[26];
        for (char c : element.toCharArray()) {
            int key = c - 'a';
            nums[key]++;
        }
        return Arrays.hashCode(nums);
    }


}
//leetcode submit region end(Prohibit modification and deletion)
