package com.example.lib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 所属项目:JavaProject
 * 所属类名:com.example.lib.LeedCode_49_376
 * 功能描述: 这方法也行 可以的
 * 创建作者:VVs
 * 创建时间:2020/2/23
 */

public class LeedCode_49_376 {

    public static void main(String[] args){


        String[] str=new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};

        groupAnagrams(str);

    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

}
