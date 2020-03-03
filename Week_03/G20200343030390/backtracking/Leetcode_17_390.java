package com.subject.week03.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 17. 电话号码组合
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。（参考图）
 *

 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 *
 * 思路（精简）：
 * 1.回溯
 * 两层 每层多个选择
 * 结束条件
 *
 *
 */
public class Leetcode_17_390 {
//    public List<String> letterCombinations(String digits) {
//        List<String> result = new ArrayList<>();
//        if(digits.length() == 0) {
//            return result;
//        }
//        Map<Character,String> map = new HashMap<>();
//        map.put('2',"abc");
//        map.put('3',"def");
//        map.put('4',"ghi");
//        map.put('5',"jkl");
//        map.put('6',"mno");
//        map.put('7',"pqrs");
//        map.put('8',"tuv");
//        map.put('9',"wxyz");
//
//        backTracking("",0,digits,result,map);
//        return result;
//
//    }
//
//    private void backTracking(String s, int level, String digits, List<String> result, Map<Character, String> map) {
//        if(level == digits.length()){
//            result.add(s);
//            return;
//        }
//        String letter = map.get(digits.charAt(level));
//        for(int j = 0; j < letter.length(); j++) {
//            backTracking(s+letter.charAt(j),level+1,digits,result,map);
//        }
//    }


    private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.length() == 0) {
            return result;
        }
        backTrackingTwo("",0,digits,result);
        return result;

    }

    private void backTrackingTwo(String s, int level, String digits, List<String> result) {
        if(level == digits.length()){
            result.add(s);
            return;
        }
        //重点
        String letter = KEYS[digits.charAt(level)-'0'];
        for(int j = 0; j < letter.length(); j++) {
            backTrackingTwo(s+letter.charAt(j),level+1,digits,result);
        }
    }


}