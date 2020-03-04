package com.test.datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GroupAnagrams49 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] array = s.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            if (map.get(key) == null) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
//        map.entrySet().forEach(entry -> {
//            result.add(entry.getValue());
//        });
//        
//        return result;
        return new ArrayList<>(map.values());
    }

    //another way to resolve
    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> result = new HashMap<String, List<String>>();
        for (String s : strs) {
            int[] key = new int[26];
            Arrays.fill(key, 0);
            char[] keyChar = s.toCharArray();
            for (char c : keyChar) {
                key[c - 'a']++;
            }
            StringBuilder builder = new StringBuilder();
            Arrays.stream(key).forEach(val -> {
                builder.append("#");
                builder.append(val);
            });

            String k = builder.toString();
            // return new sorted string
            if (result.get(k) == null) {
                result.put(k, new ArrayList<>());
            }
            result.get(k).add(s);
        }
        return new ArrayList<>(result.values());
    }

}
