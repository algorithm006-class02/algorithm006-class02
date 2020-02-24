package Week_02.G20200343030414;

import java.util.*;

/**
 * @author Xinshuai
 * @description 题目链接：https://leetcode-cn.com/problems/group-anagrams/
 * @since 2020-02-23 15:35
 */
public class LeetCode_49_414 {

    /**
     * 1、通过 Map 解决
     * <p>
     *     先排序，再分组
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String, List> groupMap = new HashMap<>();
        for(String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortStr = String.valueOf(chars);
            List valueList = groupMap.getOrDefault(sortStr, new ArrayList());
            valueList.add(str);
            groupMap.put(sortStr, valueList);
        }
        return new ArrayList(groupMap.values());
    }
}
