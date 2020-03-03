package com.youzi.leetcode;
//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
public class LetterCombinations {

    public static final Map<Character, String> MAP = new HashMap<>();

    static {
        MAP.put('2', "abc");
        MAP.put('3', "def");
        MAP.put('4', "ghi");
        MAP.put('5', "jkl");
        MAP.put('6', "mno");
        MAP.put('7', "pqrs");
        MAP.put('8', "tuv");
        MAP.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return result;
        }
        recursive(result, digits, 0, new StringBuilder());

        return result;
    }

    private void recursive(List<String> result, String digits, int arrIdx, StringBuilder sb) {
         if (arrIdx == digits.length()) {
             result.add(sb.toString());
             return;
         }

         String currentStr = MAP.get(digits.charAt(arrIdx));
         for (int i = 0; i < currentStr.length(); i++) {
             sb.append(currentStr.charAt(i));
             recursive(result, digits, arrIdx+ 1, sb);
             sb.deleteCharAt(sb.length() - 1);
         }

    }

    public static void main(String[] args) {
        new LetterCombinations().letterCombinations("23");
    }


}
//leetcode submit region end(Prohibit modification and deletion)
