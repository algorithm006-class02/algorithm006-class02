package algorithm.leetCode.week02.No49;

import java.util.*;

/**
 * @author ltw
 * on 2020-02-17.
 */
class Solution {
    //solution1 : 时间复杂度O(NKlogK) K 是 strs 中字符串的最大长度 空间复杂度 O(NK)
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0)
            return new ArrayList<>();
        Map<String, List<String>> ans = new HashMap<>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList<>());
            }
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] test = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = solution.groupAnagrams(test);
        for (List<String> list : lists) {
            for (String x : list) {
                System.out.print(x + " ");
            }
            System.out.println();
        }


    }
}


