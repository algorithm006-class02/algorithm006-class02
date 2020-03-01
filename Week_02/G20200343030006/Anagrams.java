package com.leetcode.base.week02;

import java.util.*;
import java.util.HashMap;

/**
 * 字母异位词分组
 * 思路：遍历数组，给每一个元素排序之后放入到Map的key中，并将原始数组元素添加到该key的value中
 */
public class Anagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List> res = new HashMap<>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!res.containsKey(key)) {
                res.put(key, new ArrayList());
            }
            res.get(key).add(s);
        }
        return new ArrayList(res.values());
    }

}
