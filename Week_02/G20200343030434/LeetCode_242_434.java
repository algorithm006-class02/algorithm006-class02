package algorithm.leetCode.week02.No242;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ltw
 * on 2020-02-17.
 */
class Solution {
    //solution 1 : 时间复杂度 O(n) 空间复杂度 O(n)
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            if (map.containsKey(x)) {
                map.put(x, map.get(x) + 1);
            } else {
                map.put(x, 1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            char x = t.charAt(i);
            if (!map.containsKey(x)) {
                return false;
            } else {
                if (map.get(x) == 1) {
                    map.remove(x);
                } else {
                    map.put(x, map.get(x) - 1);
                }
            }
        }
        return map.keySet().isEmpty();
    }

    //solution2: 时间复杂度 O(n) 空间复杂度 O(1) 题目思路有点类似于 bloomfilter 实际上使用桶来解决，
    // 但如果 范围变大例如是从 1～1w的数据来做异位分析，空间会变得很大。
//    public boolean isAnagram(String s, String t) {
//        if (s.length() != t.length()) {
//            return false;
//        }
//        int[] table = new int[26];
//        for (int i = 0; i < s.length(); i++) {
//            table[s.charAt(i) - 'a']++;
//        }
//        for (int i = 0; i < t.length(); i++) {
//            table[t.charAt(i) - 'a']--;
//            if (table[t.charAt(i) - 'a'] < 0) {
//                return false;
//            }
//        }
//        return true;
//    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isAnagram("a", "ab"));
    }
}

