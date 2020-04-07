package com.ping.leetcode.easy;

import java.util.HashMap;

/**
 * @Author: 高一平
 * @Date: 2020/4/5
 * @Description: 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * 案例:
 * s = "leetcode"
 * 返回 0.
 * s = "loveleetcode",
 * 返回 2.
 * 注意事项：您可以假定该字符串只包含小写字母。
 **/
public class FirstUniqChar387 {

    public int firstUniqChar(String s) {
        return firstUniqChar1(s);
    }

    /**
     * 先统计各字符出现的次数
     * 再按顺序查询第一个出现次数为 1 的字符
     *
     * @param s
     * @return
     */
    private int firstUniqChar1(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>(s.length());
        // 1、统计各字符出现的次数
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // 2、查询第一个出现次数为 1 的字符
        for (int i = 0; i < s.length(); i++) {
            Integer num = map.get(s.charAt(i));
            if (num == 1) {
                return i;
            }
        }
        return -1;
    }

}
