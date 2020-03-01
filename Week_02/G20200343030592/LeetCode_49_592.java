package com.gsf.geekbang_demo.arithmetic.leetCode;

import java.util.*;

public class Demo49 {

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
//        List<List<String>> lists = Demo49.groupAnagrams1(strs);
        List<List<String>> lists = Demo49.groupAnagrams2(strs);
        System.err.println(lists.toString());
    }

    /*
    优化方法一
     */
    private static List<List<String>> groupAnagrams2(String[] strs) {
        if (strs.length == 0) return new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                map.put(key, new ArrayList<>(Arrays.asList(str)));
            }
        }
        return new ArrayList(map.values());
    }

    /*
    先排序,再将排好序的字符串当key放到Map中，没排序的字符串当value。最后遍历value.
     */
    public static List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            if (map.get(Arrays.toString(chars)) != null) {
                map.get(Arrays.toString(chars)).add(str);
            } else {
                map.put(Arrays.toString(chars), new ArrayList<>(Arrays.asList(str)));
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (List<String> list : map.values()) {
            result.add(list);
        }
        return result;
    }
}
