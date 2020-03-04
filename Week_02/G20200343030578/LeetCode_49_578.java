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


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new ArrayList<>();

        // 1. 对所有字符串进行排序，形成新字符串数组
        // 2. 遍历新的字符串数组，新建一个哈希表 <String, List<String>>
            // 如果哈希表中存在以字符串为 key 的键值对，
                // 那么将对应原字符串加入到其 value 的 List 中
            // 否则
                // 在哈希表中增添对应的键值对

        String[] str_sorted =  new String[strs.length];

        for (int i = 0; i < strs.length; i++) {
            char[] str = strs[i].toCharArray();
            Arrays.sort(str);
            str_sorted[i] = String.valueOf(str);
        }

        HashMap<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < str_sorted.length; i++) {
            if(map.containsKey(str_sorted[i])){
                map.get(str_sorted[i]).add(strs[i]);
            }else{
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(str_sorted[i],list);
            }
        }

        for (List<String> list: map.values()) {
            result.add(list);
        }
        
        return result;

    }

    public static void main(String[] args) {
        Solution49 sln = new Solution49();
        String[] strings = new String[]{"eat","tea","tan","ate","nat","bat"};
        System.out.println(sln.groupAnagrams(strings));
    }
}

